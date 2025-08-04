package bank.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class AccountTrace {
    @Id
    @GeneratedValue
    private long id;
    private LocalDateTime dateTime;
    private long accountNumber;
    private String operation;
    private double amount;

    public AccountTrace() {
    }

    public AccountTrace(long accountNumber, String operation, double amount) {
        this.dateTime = LocalDateTime.now();
        this.accountNumber = accountNumber;
        this.operation = operation;
        this.amount = amount;
    }
}
