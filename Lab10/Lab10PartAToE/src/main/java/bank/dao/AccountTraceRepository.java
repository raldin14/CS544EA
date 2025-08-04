package bank.dao;

import bank.domain.AccountTrace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountTraceRepository extends JpaRepository<AccountTrace, Long> {
}
