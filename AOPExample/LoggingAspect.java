package com.AOPExample;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.AOPExample.PaymentService.*(..))")
    public void logBefore() {
        System.out.println("[LOG] Method execution started...");
    }
}
