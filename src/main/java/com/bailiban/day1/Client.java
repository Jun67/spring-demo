package com.bailiban.day1;

import com.bailiban.day1.model.User;
import com.bailiban.day1.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Client client = (Client) context.getBean("client");
        client.userService.add(new User(1001, "Jim"));
    }
}
