package bank.service;

import bank.domain.Tracerecord;
import bank.repositories.TracerecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TracerecordService {
    @Autowired
    TracerecordRepository tracerecordRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void logTracerecord(String result){
        tracerecordRepository.save(new Tracerecord(result));
    }
}
