package jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CalculatorMessageListener {
    private int total = 0;

    @JmsListener(destination = "testCalculatorQueue")
    public void receiveMessage(final String calculatorAsString) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Calculator calculator = objectMapper.readValue(calculatorAsString, Calculator.class);

            switch (calculator.getOperaton()){
                case '+' -> total += calculator.getNumber();
                case '-' -> total -= calculator.getNumber();
                case '*' -> total *= calculator.getNumber();
                default -> {
                    System.out.println("Unsupported operator: "+ calculator.getOperaton());
                    return;
                }
            }
            System.out.println("JMS receiver Calculator received message: Operator " + calculator.getOperaton() + " value: "+calculator.getNumber()+ " Result: "+ total);
        } catch (IOException e) {
            System.out.println("JMS receiver Calculator: Cannot convert : " + calculatorAsString+" to a Calculator object");
        }
    }
}
