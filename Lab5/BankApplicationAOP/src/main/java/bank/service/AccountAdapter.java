package bank.service;

import bank.domain.Account;
import bank.domain.Customer;
import bank.dto.AccountDTO;
import bank.dto.AccountEntryDTO;
import bank.dto.CustomerDTO;

import java.util.List;
import java.util.stream.Collectors;

public class AccountAdapter {
    public static AccountDTO toDTO(Account account) {

        Customer customer = account.getCustomer();
        CustomerDTO customerDTO = new CustomerDTO(
                customer.getName()
        );

        List<AccountEntryDTO> entryDTOs = account.getEntryList().stream()
                .map(entry -> new AccountEntryDTO(
                        entry.getDate(),
                        entry.getAmount(),
                        entry.getDescription(),
                        entry.getFromAccountNumber(),
                        entry.getFromPersonName()
                )).collect(Collectors.toList());

        return new AccountDTO(account.getAccountnumber(), customerDTO, entryDTOs);

    }
}
