package com.bailiban.day3.spring_annotation.autowire.qualifier;

import com.bailiban.day3.spring_annotation.autowire.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Client {

    /**
     * 当Spring容器中有多个相同类型的实例对象时，必须指定要注入的是哪一个对象。
     * 可以使用@Qualifier来指定bean的名称。
     */
    @Autowired
    @Qualifier("accountService_setter")
    private AccountService accountService;

    public AccountService getAccountService() {
        return accountService;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                "com.bailiban.day3.spring_annotation.autowire");
        Client client = (Client) context.getBean("client");
        client.getAccountService().create();
    }
}
