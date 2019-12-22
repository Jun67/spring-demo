package com.bailiban.day4.aop.aopxml;



import org.aspectj.lang.JoinPoint;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogAdvice {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void logger(JoinPoint joinPoint) {
        System.out.println(dateFormat.format(new Date()) + ": method " + joinPoint.getSignature().getName() + " invoked.");
    }
}
