package com.bailiban.day4.aop.aopxml.transaction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Client {

    public static void main(String[] args) throws SQLException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "com/bailiban/day4/aop/aopxml/transaction/transaction.xml");
        AccountService service = context.getBean(AccountService.class);
        service.transfer2(12, 10, 100);
        context.close();
    }
}
