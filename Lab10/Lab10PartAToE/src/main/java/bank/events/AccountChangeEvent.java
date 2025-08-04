package bank.events;

import org.springframework.stereotype.Component;

public class AccountChangeEvent {
    private final long accountNumber;
    private final String operation;
    private final double amount;

    public AccountChangeEvent(long accountNumber, String operation, double amount) {
        this.accountNumber = accountNumber;
        this.operation = operation;
        this.amount = amount;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public String getOperation() {
        return operation;
    }

    public double getAmount() {
        return amount;
    }
}
