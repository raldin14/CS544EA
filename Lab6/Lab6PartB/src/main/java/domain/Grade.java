package domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Grade {
    @Id
    @GeneratedValue
    private long id;
    private double grade;

    public Grade() {
    }

    public Grade(double grade) {
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", grade=" + grade +
                '}';
    }
}
