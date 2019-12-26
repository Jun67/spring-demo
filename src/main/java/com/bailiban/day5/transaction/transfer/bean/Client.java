package com.bailiban.day5.transaction.transfer.bean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "com/bailiban/day5/transaction/transfer/bean/transaction.xml");
        AccountService accountService = (AccountService) context.getBean("accountServiceProxy");
        accountService.transfer(12, 10, 10000000);
    }
}
