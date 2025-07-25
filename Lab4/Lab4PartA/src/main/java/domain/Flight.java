package domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Flight {
    @Id
    @GeneratedValue
    private long id;
    private int flightNumber;
    @Column(name = "f_from")
    private String from;
    @Column(name = "f_to")
    private String to;
    private Date date;

    public Flight() {
    }

    public Flight(int flightNumber, String from, String to, Date date) {
        this.flightNumber = flightNumber;
        this.from = from;
        this.to = to;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flightNumber=" + flightNumber +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", date=" + date +
                '}';
    }
}
