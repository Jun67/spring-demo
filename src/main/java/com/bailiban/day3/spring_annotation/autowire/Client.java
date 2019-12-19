package com.bailiban.day3.spring_annotation.autowire;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                "com.bailiban.day3.spring_annotation.autowire");
        AccountService service = (AccountService) context.getBean("accountService_field");
        service.create();
    }
}
