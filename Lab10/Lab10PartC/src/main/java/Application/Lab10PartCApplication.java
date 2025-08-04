package Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({InformationProperty.class, UserProperty.class})
public class Lab10PartCApplication implements CommandLineRunner {
	@Autowired
	InformationProperty informationProperty;
	@Autowired
	UserProperty userProperty;

	public static void main(String[] args) {
		SpringApplication.run(Lab10PartCApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("=== Application Info ===");
		System.out.printf("Name: %s%n", informationProperty.getName());
		System.out.printf("Version: %s%n", informationProperty.getVersion());
		System.out.println();

		System.out.println("=== Server ===");
		System.out.printf("URL: %s%n", informationProperty.getServer().getUrl());
		System.out.printf("Name: %s%n", informationProperty.getServer().getName());
		System.out.println();

		System.out.println("=== User ===");
		System.out.printf("First Name: %s%n", userProperty.getFirstname());
		System.out.printf("Last Name: %s%n", userProperty.getLastname());
		System.out.printf("Username: %s%n", userProperty.getUsername());
		System.out.printf("Password: %s%n", userProperty.getPassword());
		System.out.println();

		System.out.println("=== Countries ===");
		informationProperty.getCountries().forEach(c -> System.out.printf("- %s%n", c));
	}
}
