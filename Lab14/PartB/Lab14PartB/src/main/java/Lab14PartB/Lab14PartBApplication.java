package Lab14PartB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab14PartBApplication implements CommandLineRunner {
	@Autowired
	private ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(Lab14PartBApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productService.create(new Product("Acme Dog Food - Chicken", "Premium dry dog food (5kg)", "Pets", 29.99));
		productService.create(new Product("Kitty Clean Litter", "Clumping cat litter, 10L", "Pets", 12.49));
		productService.create(new Product("Flea Guard Spray", "Flea & tick spray for dogs", "Medications", 9.95));
		productService.create(new Product("Rubber Ball", "Durable chew/play ball for dogs", "Toys", 4.99));
	}
}
