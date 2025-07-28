package app;

import domain.Course;
import domain.Department;
import domain.Grade;
import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repository.CourseRepository;
import repository.StudentRepository;

@SpringBootApplication
@EnableJpaRepositories("repository")
public class Lab6PartBApplication implements CommandLineRunner {
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	CourseRepository courseRepository;
	public static void main(String[] args) {
		SpringApplication.run(Lab6PartBApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student student1 = new Student("John");
		Department department1 = new Department("CS");

		student1.setDepartment(department1);

		Grade grade1 = new Grade(87);
		Grade grade2 = new Grade(95);

		student1.addGrades(grade1);
		student1.addGrades(grade2);


		Course course1 = new Course("CSEA");
		courseRepository.save(course1);

		grade1.setCourse(course1);
		grade2.setCourse(course1);

		studentRepository.save(student1);
	}
}
