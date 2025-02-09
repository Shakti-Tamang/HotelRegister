package com.microservices.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
//AOP
@Aspect
@Component
public class ServiceAspect {

 private static final Logger logger= LoggerFactory.getLogger(ServiceAspect.class);

    @Before("execution(* com.microservices.controller.*.*(..))")
    public void logBeforeMethodExecution(JoinPoint joinPoint) {
        logger.info("Method called: " + joinPoint.getSignature().toShortString());
    }

}
