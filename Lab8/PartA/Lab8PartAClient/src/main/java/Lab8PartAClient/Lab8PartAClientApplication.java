package Lab8PartAClient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchProperties;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class Lab8PartAClientApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Lab8PartAClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		String serverUrl = "http://localhost:8080/books";
		RestClient restClient = RestClient.builder()
				.baseUrl("http://localhost:8080/books")
				.build();

		//Add book
		Book book1 = restClient.post()
				.uri("/")
				.contentType(MediaType.APPLICATION_JSON)
				.body(new Book("Equate","Raldin Hidalgo","12534",20.99))
				.retrieve()
				.body(Book.class);

		Book book2 = restClient.post()
				.uri("/")
				.contentType(MediaType.APPLICATION_JSON)
				.body(new Book("CC Programin","Raldin Hidalgo","22487",14.99))
				.retrieve()
				.body(Book.class);

		Book equate = restClient.get()
				.uri("/author/{author}","raldin")
				.retrieve()
				.body(Book.class);
		System.out.println(equate);

	}
}
