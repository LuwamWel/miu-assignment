package customers;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Configuration
public class EmailSenderAspect {

    @Autowired
    private ILogger logger;

    @After("execution(* customers.EmailSender.sendEmail(..))")
    public void logAfterSendEmail(JoinPoint joinPoint) {
        EmailSender emailSender = (EmailSender) joinPoint.getTarget();
        System.out.println((LocalDateTime.now() + " method="+ joinPoint.getSignature().getName() + " Address = "+
                joinPoint.getArgs()[0]) + " message = "+ joinPoint.getArgs()[1] + " outgoing mail server = " + emailSender.outgoingMailServer);
    }
}
