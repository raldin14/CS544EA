package bank.repositories;

import bank.domain.Tracerecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TracerecordRepository extends JpaRepository<Tracerecord,Long> {
}
