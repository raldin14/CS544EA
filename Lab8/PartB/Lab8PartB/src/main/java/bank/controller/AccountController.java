package bank.controller;

import bank.service.AccountDTO;
import bank.service.IAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

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

    @PostMapping("/{accountNumber}/deposit")
    public ResponseEntity<?> deposit(@PathVariable("accountNumber") long accountNumber,@RequestParam double amount, @RequestParam String currency){
        if(currency.equals("euro")){
            accountService.depositEuros(accountNumber,amount);
        }else {
            accountService.deposit(accountNumber, amount);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{accountNumber}/withdraw")
    public ResponseEntity<?> withdraw(@PathVariable("accountNumber") long accountNumber,@RequestParam double amount, @RequestParam String currency){
        if(currency.equals("euro")){
            accountService.withdrawEuros(accountNumber,amount);
        }else {
            accountService.withdraw(accountNumber, amount);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{accountNumber}/transfer/{accountBenefit}")
    public ResponseEntity<?> transferFunds(@PathVariable("accountNumber") long accountNumber, @PathVariable("accountBenefit") long accountBenefit,@RequestParam  double amount,@RequestParam  String description){
        accountService.transferFunds(accountNumber,accountBenefit,amount,description);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllAccounts(){
        Collection<AccountDTO> accounts = accountService.getAllAccounts();
        return new ResponseEntity<Collection<AccountDTO>>(accounts,HttpStatus.OK);
    }
}
