package com.bailiban.day5.transaction.xmltest;

import com.bailiban.day5.transaction.annotation.BookShopService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("transaction/xmltest/transaction.xml");
        BookShopService shopService = (BookShopService) context.getBean("bookShopService");
        shopService.purchase("AA", "1001");
    }
}
