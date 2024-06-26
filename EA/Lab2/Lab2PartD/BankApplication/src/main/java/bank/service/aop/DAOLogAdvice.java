package bank.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class DAOLogAdvice {
    //in the bank.dao package

    @After("execution(* bank.dao.*.*(..))")
    public void logAfterMethod(JoinPoint joinPoint) {
        System.out.println("after execution of method "+ joinPoint .getSignature().getName());
    }

}
