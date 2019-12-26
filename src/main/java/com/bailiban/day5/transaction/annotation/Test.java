package com.bailiban.day5.transaction.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TransConfig.class);
//        BookShopDao bookShopDao = (BookShopDao) context.getBean("bookShopDao");
//        System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
        Cashier cashier = (Cashier) context.getBean("cashier");
        cashier.checkout("AA", Arrays.asList("1001"));
        context.close();
    }
}
