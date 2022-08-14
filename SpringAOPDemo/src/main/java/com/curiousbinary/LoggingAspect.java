package com.curiousbinary;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.curiousbinary.ShoppingCart.checkout(..))")
    public void beforeLogger(JoinPoint jp) {
        String arg = jp.getArgs()[0].toString();
        System.out.println("Before logger: " + arg);
    }

    @After("execution(* *.*.*.checkout(..))")
    public void afterLogger(JoinPoint jp) {
        System.out.println("After logger: " + jp.getSignature());
    }

    @Pointcut("execution(* *.*.*.getQuantity(..))")
    public void afterReturningPointCut() {
    }

    @AfterReturning(pointcut = "afterReturningPointCut()", returning = "retval")
    public void afterReturning(int retval) {
        System.out.println("After returning..." + retval);
    }
}
