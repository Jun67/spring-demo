package com.bailiban.day4.aop.annotation.transaction;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.sql.SQLException;

@Configuration
@ComponentScan("com.bailiban.day4.aop.annotation.transaction")
@EnableAspectJAutoProxy
public class Client {

    public static void main(String[] args) throws SQLException {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Client.class);
        AccountService service = context.getBean(AccountService.class);
        service.transfer(12, 10, 100);
        context.close();
    }
}
