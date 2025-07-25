package domain;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private long employeeNumber;
    private String name;
    @ManyToOne
    private Department department;

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber=" + employeeNumber +
                ", name='" + name + '\'' +
                '}';
    }

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
