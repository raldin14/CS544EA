package repository;

import domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> getAllStudentFromDepartmentName(String department);
    List<Student> getAllStudentFromCourseName(String course);
}
