package com.bailiban.day5.transaction.transfer.interceptor;

import com.bailiban.day5.transaction.transfer.bean.AccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "com/bailiban/day5/transaction/transfer/interceptor/transaction.xml");
        AccountService accountService = (AccountService) context.getBean("accountService");
        accountService.transfer(12, 10, 10000000);
    }
}
