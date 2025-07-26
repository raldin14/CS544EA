package app;

import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.CustomerRepository;
import repositories.OrderRepository;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain") 
public class OrderApplication implements CommandLineRunner{
	
	@Autowired
	OrderRepository orderRepository;
	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book product = new Book();
		product.setName("Hibernate 3");
		product.setDescription("Good book on Hibernate");
		product.setPrice(35.50);
		product.setIsbn(123456);
		OrderLine ol1 = new OrderLine(2, product);
//		Book book = new Book(product.getName(),product.getDescription(), product.getPrice(), 123456);

		CD product2 = new CD();
		product2.setName("The best of Queen");
		product2.setDescription("Album from 1995");
		product2.setPrice(12.98);
		product2.setArtis("Queen");
		OrderLine ol2 = new OrderLine(4, product2);

		Order o1 = new Order("234743", "12/10/06", "open");
		o1.addOrderLine(ol1);
		o1.addOrderLine(ol2);

		Customer c1 = new Customer("Frank", "Brown", "Mainstreet 1",
				"New york", "43221");
		c1.addOrder(o1);
		o1.setCustomer(c1);

		orderRepository.save(o1);
		printOrder(o1);
	}

	public static void printOrder(Order order) {
		System.out.println("Order with orderNumber: " + order.getOrdernr());
		System.out.println("Order date: " + order.getDate());
		System.out.println("Order status: " + order.getStatus());
		Customer cust = order.getCustomer();
		System.out.println("Customer: " + cust.getFirstname() + " "
				+ cust.getLastname());
		for (OrderLine orderline : order.getOrderlines()) {
			System.out.println("Order line: quantity= "
					+ orderline.getQuantity());
			Product product = orderline.getProduct();
			System.out.println("Product: " + product.getName() + " "
					+ product.getDescription() + " " + product.getPrice());
		}

	}
}
