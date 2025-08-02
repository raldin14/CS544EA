package jms;

public class Calculator {
    private char operator;
    private int number;

    public Calculator(){}

    public Calculator(int number, char operator) {
        this.number = number;
        this.operator = operator;
    }

    public char getOperaton() {
        return operator;
    }

    public void setOperaton(char operator) {
        this.operator = operator;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
