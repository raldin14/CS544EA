package org.example;

public class Calculator {
    private double value;

    public Calculator() {
        value =0.0;
    }
    public void add(double number) {
        value = value + number;
    }
    public void subtract (double number) {
        value = value - number;
    }
    public void multiply(double number) {
        value = value * number;
    }
    public void divide (double number) throws DivideByZeroException{
        if (number == 0){
            throw new DivideByZeroException();
        }
        value = value / number;
    }
    public double getValue() {
        return value;
    }
}
