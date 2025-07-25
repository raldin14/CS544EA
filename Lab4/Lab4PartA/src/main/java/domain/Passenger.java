package domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Passenger {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "passgr_flight")
    @OrderColumn(name = "flight_order")
    List<Flight> flights = new ArrayList<>();

    public Passenger() {
    }

    public Passenger(String name) {
        this.name = name;
    }

    public void addFlight(Flight flights) {
        this.flights.add(flights);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", flights=" + flights +
                '}';
    }
}
