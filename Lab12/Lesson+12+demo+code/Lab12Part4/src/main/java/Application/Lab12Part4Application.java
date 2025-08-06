package Application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

@SpringBootApplication
public class Lab12Part4Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Lab12Part4Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Lab12Part4Application client = new Lab12Part4Application();

		// Try accessing endpoints as Bob (sales)
		System.out.println("===== Accessing as Bob =====");
		client.callEndpoint("/shop", "bob", "pass");
		client.callEndpoint("/orders", "bob", "pass");
		client.callEndpoint("/payments", "bob", "pass");

		// Try accessing endpoints as Mary (finance)
		System.out.println("\n===== Accessing as Mary =====");
		client.callEndpoint("/shop", "mary", "pass");
		client.callEndpoint("/orders", "mary", "pass");
		client.callEndpoint("/payments", "mary", "pass");
	}

	private void callEndpoint(String path, String username, String password) throws Exception {
		String baseUrl = "http://localhost:8080";
		String auth = username + ":" + password;
		String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(baseUrl + path))
				.header("Authorization", "Basic " + encodedAuth)
				.GET()
				.build();

		HttpClient httpClient = HttpClient.newHttpClient();

		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

		System.out.printf("Request: %s | Status: %d%n", path, response.statusCode());
		System.out.println("Response: " + response.body());
		System.out.println("----------------------------------------");
	}
}
