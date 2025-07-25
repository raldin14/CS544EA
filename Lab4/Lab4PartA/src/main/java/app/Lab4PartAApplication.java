package app;

import domain.*;
import repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain")
public class Lab4PartAApplication implements CommandLineRunner {
	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	PublisherRepository publisherRepository;
	@Autowired
	BookRepository bookRepository;
	@Autowired
	PassengerRepository passengerRepository;
	@Autowired
	SchoolRepository schoolRepository;

	public static void main(String[] args) {
		SpringApplication.run(Lab4PartAApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("--------Star the application-----------");
		Department hr_dep = new Department("HR");

		hr_dep.addEmployee(new Employee("John Smith"));
		hr_dep.addEmployee(new Employee("Anna Stward"));
		hr_dep.addEmployee(new Employee("Jenniffer Allen"));

		departmentRepository.save(hr_dep);

		System.out.println("------Retreaving deparments-----------");
		for (Department dept : departmentRepository.findAll()) {
			System.out.println(dept);
		}
		System.out.println();

		System.out.println("-------------Book - Publisher --------------");
		Publisher susaeta = new Publisher("Susaeta");
		publisherRepository.save(susaeta);

		Book cc = new Book("Clean Code","Robert C. Martin");
		Book ej = new Book("Effective Java", "Joshua Bloch");
		Book ia = new Book("Introduction to Algorithms", "Thomas H. Cormen");
		cc.setPublisher(susaeta);
		ej.setPublisher(susaeta);
		bookRepository.save(ej);
		bookRepository.save(cc);
		bookRepository.save(ia);

		System.out.println("-----------Passenger flights-----------");
		Passenger passenger = new Passenger("Luis Logan");
		Flight goinTo = new Flight(209, "cid","jfk",new Date());
		Flight returningFrom = new Flight(308,"lga","cid",new Date());

		passenger.addFlight(goinTo);
		passenger.addFlight(returningFrom);

		passengerRepository.save(passenger);

		System.out.println(passenger);

		System.out.println("----------School students---------");
		School school = new School("Elemantary School");

		Student std1 = new Student("Raldin","Hidalgo");
		Student std2 = new Student("Aida","Garcia");

		school.addStudent(std1);
		school.addStudent(std2);

		schoolRepository.save(school);

		System.out.println(school);
	}
}
