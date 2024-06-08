package edu.miutest.demo.aspect;

import edu.miutest.demo.entity.Logger;
import edu.miutest.demo.repo.LoggerRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
@AllArgsConstructor
@Slf4j
public class LoggingAspect {
    private final LoggerRepo loggerRepo;
    //use fake user
    private static final String PRINCIPLE = "fakeUser";

    @Before("execution(* edu.miutest.demo.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getMethod().getName();

        Logger logEntry = new Logger();
        logEntry.setDateTime(LocalDateTime.now());
        logEntry.setPrinciple(PRINCIPLE);
        logEntry.setOperation("Executing method: " + methodName);

        loggerRepo.save(logEntry);
    }

    @Around("@annotation(edu.miutest.demo.aspect.ExecutionTime)")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;
        log.info(joinPoint.getSignature() + " executed in " + executionTime + "ms");

        Logger logEntry = new Logger();
        logEntry.setDateTime(LocalDateTime.now());
        logEntry.setPrinciple(PRINCIPLE);
        logEntry.setOperation(joinPoint.getSignature() + " executed in " + executionTime + "ms");

        loggerRepo.save(logEntry);

        return proceed;
    }
}
