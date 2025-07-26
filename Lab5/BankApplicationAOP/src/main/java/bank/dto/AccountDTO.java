package bank.dto;

import java.util.List;

public record AccountDTO(long accountNumber, CustomerDTO customer, List<AccountEntryDTO> entries) {
}
