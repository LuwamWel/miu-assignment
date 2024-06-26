package bank.service.aop;

import bank.logging.ILogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class JMSLogAdvice {

    @Autowired
    private ILogger logger;

    @After("execution(* bank.jms.JMSSender.*(..))")
    public void after(JoinPoint joinPoint) {
        logger.log(" JMSSender executed "+ joinPoint .getSignature().getName());
    }
}
