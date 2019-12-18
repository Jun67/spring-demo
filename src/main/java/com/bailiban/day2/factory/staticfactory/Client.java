package com.bailiban.day2.factory.staticfactory;

import com.bailiban.day1.helloworld.dao.UserDao;
import com.bailiban.day1.helloworld.model.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "com/bailiban/day2/factory/staticfactory/staticFactory.xml");
        User user = (User) context.getBean("user");
        System.out.println(user);
        UserDao userDao = (UserDao) context.getBean("userDao");
        System.out.println(userDao);
    }
}
