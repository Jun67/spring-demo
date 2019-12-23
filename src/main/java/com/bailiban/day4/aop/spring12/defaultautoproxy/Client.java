package com.bailiban.day4.aop.spring12.defaultautoproxy;

import com.bailiban.day4.aop.dynamic_proxy.noproxy.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "com/bailiban/day4/aop/spring12/defaultautoproxy/defaultautoproxy.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.getUser();
        userService.createUser();
        userService.updateUser();
        userService.deleteUser();
    }
}
