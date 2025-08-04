package bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Collection;
@Component
public class BankStatementPrinter {
    @Autowired
    private IAccountService accountService;
    @Scheduled(fixedRate = 10000)
    public void printDetails(){
        Collection<AccountDTO> accountlist = accountService.getAllAccounts();
        CustomerDTO customer = null;
        for (AccountDTO account : accountlist) {
            customer = account.getCustomer();
            System.out.println("Statement for Account: " + account.getAccountnumber());
            System.out.println("Account Holder: " + customer.getName());
            System.out.println(
                    "-Date-------------------------" + "-Description------------------" + "-Amount-------------");
            for (AccountEntryDTO entry : account.getEntryList()) {
                System.out.printf("%30s%30s%20.2f\n", entry.getDate().toString(), entry.getDescription(),
                        entry.getAmount());
            }
            System.out.println("----------------------------------------" + "----------------------------------------");
            System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:", account.getBalance());
        }
    }
}
