package bank.controller;

import bank.service.AccountDTO;
import bank.service.IAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bank")
public class AccountController {
    IAccountService accountService;
    @PostMapping("/")
    public ResponseEntity<?>createAccount(@RequestBody AccountDTO account){
        long accountnumber = account.getAccountnumber();
        String customer = account.getCustomer().getName();
        return new ResponseEntity<AccountDTO>(accountService.createAccount(accountnumber,customer), HttpStatus.OK);
    }

    @PostMapping("/deposit")
    public ResponseEntity<?> deposit(@RequestParam long accountNumber, double amount){
        accountService.deposit(accountNumber, amount);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/euro")
    public ResponseEntity<?> depositEuro(@RequestParam long accountNumber, double amount){
        accountService.depositEuros(accountNumber,amount);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
