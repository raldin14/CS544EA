package bank.aop;

import bank.domain.Customer;
import bank.domain.Tracerecord;
import bank.repositories.TracerecordRepository;
import bank.service.TracerecordService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class TracereportAdvice {
    @Autowired
    TracerecordService tracerecordService;

    @Around("execution(* bank.service.BankService.createCustomerAndAccount(..))")
    public Object traceAfterMethod(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("------------------------------Calling th advisor----------------------------");
        try{
            Object object = joinPoint.proceed();
            System.out.println("---------------------------Success-------------------------------------");
//            tracerecordService.logTracerecord("Customer "+customerName+" created with account "+AccountNumber);
            return object;
        } catch (Exception e) {
            System.out.println("--------------------------Fail---------------------------------------");
//            tracerecordService.logTracerecord("Could not create customer "+customerName+" with account "+AccountNumber);
            throw e;
        }
    }
}
