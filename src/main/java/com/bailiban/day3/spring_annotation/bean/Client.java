package com.bailiban.day3.spring_annotation.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                "com.bailiban.day3.spring_annotation.bean");
        AccountService service = (AccountService) context.getBean("accountService_setter");
        service.create();
    }
}
