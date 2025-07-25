package domain;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class School {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @OneToMany(cascade = CascadeType.PERSIST)
    @MapKey(name = "studentId")
    Map<Long, Student> student = new HashMap<>();

    public School() {
    }

    public School(String name) {
        this.name = name;
    }

    public void addStudent(Student std){
        student.put(std.getStudentId(), std);
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }
}
