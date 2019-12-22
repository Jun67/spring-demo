package com.bailiban.day4.aop.annotation;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Aspect
public class LogAdvice {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @After("execution(* com..aop.annotation.UserServiceImpl.*(..))")
    public void logger(JoinPoint joinPoint) {
        System.out.println(dateFormat.format(new Date()) + ": method " + joinPoint.getSignature().getName() + " invoked.");
    }
}
