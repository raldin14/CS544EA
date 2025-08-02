package application;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TaxServiceMessageListener {

    @JmsListener(destination = "testQueue")
    public void receiveMessage(final String message){
        System.out.println("JMS receiver: "+ message);
    }
}
