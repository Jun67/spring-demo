package com.bailiban.day5.transaction.transfer.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AccountService accountService = (AccountService) context.getBean("accountService");
        accountService.transfer(10, 12, 10);
//        accountService.get(12);
    }
}
