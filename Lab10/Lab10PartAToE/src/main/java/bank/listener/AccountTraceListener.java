package bank.listener;

import bank.dao.AccountTraceRepository;
import bank.domain.AccountTrace;
import bank.events.AccountChangeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AccountTraceListener {
    @Autowired
    private AccountTraceRepository accountTraceRepository;

    @EventListener
    public void handleAccountChange(AccountChangeEvent event){
        AccountTrace trace = new AccountTrace(
                event.getAccountNumber(),event.getOperation(),event.getAmount()
        );

        accountTraceRepository.save(trace);
        System.out.println("Trace record saved fro account: "+event.getAccountNumber());
    }
}
