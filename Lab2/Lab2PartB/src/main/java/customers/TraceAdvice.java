package customers;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

import java.time.LocalDateTime;

@Aspect
@Configuration
public class TraceAdvice
{
    @Autowired
    private ILogger logger;

    @After("execution(* customers.EmailSender.sendEmail(..)) && args(email, message)")
    public void tracemethod(JoinPoint joinPoint, String email, String message){
        EmailSender outGoing = (EmailSender) joinPoint.getTarget();
        logger.log(" method ="+joinPoint.getSignature().getName()+ " address ="+email + " message="+message+ " outgoing mail server ="+ outGoing.getOutgoingMailServer());
    }

    @Around("execution(* customers.CustomerDAO.save(..))")
    public Object invoke(ProceedingJoinPoint call ) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();
        long totaltime = sw.getLastTaskTimeMillis();
// print the time to the console
        System.out.println("Duration of the method calls "+totaltime+" ms");
        return retVal;
    }
}
