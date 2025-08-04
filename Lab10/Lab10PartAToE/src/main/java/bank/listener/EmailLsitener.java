package bank.listener;

import bank.events.AccountChangeEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmailLsitener {
    @EventListener
    public void sendEmailOnChange(AccountChangeEvent event){
        System.out.printf("Sending email: Account %s - %s of %.2f%n",
                event.getAccountNumber(), event.getOperation(), event.getAmount());
    }
}
