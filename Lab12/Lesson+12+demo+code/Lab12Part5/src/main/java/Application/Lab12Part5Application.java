package Application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

@SpringBootApplication
public class Lab12Part5Application implements CommandLineRunner {
	private static final String AUTH_URL = "http://localhost:8080/auth";
	private static final String SECURE_URL = "http://localhost:8080/api";
	public static void main(String[] args) {
		SpringApplication.run(Lab12Part5Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Lab12Part5Application client = new Lab12Part5Application();

		// Try accessing endpoints as Bob (sales)
		System.out.println("===== Info is open to everyone =====");
		client.callEndpoint("/signin","/all", "john@gmail.com", "user");
		System.out.println("===== Accessing as user =====");
		client.callEndpoint("/signin","/users", "john@gmail.com", "user");
		System.out.println("===== Accessing as user =====");
		client.callEndpoint("/signin","/admins", "admin@admin.com", "password");

	}

	private void callEndpoint(String auth, String path, String username, String password) throws Exception {

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders authHeaders = new HttpHeaders();
		authHeaders.setContentType(MediaType.APPLICATION_JSON);

		String loginBody = String.format("{\"email\":\"%s\", \"password\":\"%s\"}", username, password);
		HttpEntity<String> loginRequest = new HttpEntity<>(loginBody, authHeaders);

		try {
			ResponseEntity<String> authResponse = restTemplate.exchange(
					AUTH_URL+auth,
					HttpMethod.POST,
					loginRequest,
					String.class
			);

			if (authResponse.getStatusCode() == HttpStatus.OK) {
				String responseBody = authResponse.getBody();
				String token = extractToken(responseBody);
				System.out.println("JWT Token: " + token);

				// Step 2: Use token to access secure endpoint
				HttpHeaders secureHeaders = new HttpHeaders();
				secureHeaders.setBearerAuth(token);

				HttpEntity<Void> secureRequest = new HttpEntity<>(secureHeaders);

				ResponseEntity<String> secureResponse = restTemplate.exchange(
						SECURE_URL+path,
						HttpMethod.GET,
						secureRequest,
						String.class
				);

				System.out.println("Secure API Response: " + secureResponse.getBody());
			} else {
				System.out.println("Failed to authenticate. Status: " + authResponse.getStatusCode());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String extractToken(String json) {
		// Very basic parsing — assumes {"token":"..."}
		int tokenIndex = json.indexOf(":\"") + 2;
		int endIndex = json.indexOf("\"", tokenIndex);
		return json.substring(tokenIndex, endIndex);
	}
}
