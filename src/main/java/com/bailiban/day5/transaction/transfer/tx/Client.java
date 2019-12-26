package com.bailiban.day5.transaction.transfer.tx;

import com.bailiban.day5.transaction.transfer.bean.AccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "com/bailiban/day5/transaction/transfer/tx/transaction.xml");
        AccountService accountService = (AccountService) context.getBean("accountService");
        accountService.transfer(12, 10, 10000000);
    }
}
