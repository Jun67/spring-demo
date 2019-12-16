package com.bailiban.day1.helloworld;

import com.bailiban.day1.helloworld.model.User;
import com.bailiban.day1.helloworld.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        // 通过xml文件，获取Spring容器上下文
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 使用Spring提供的getBean方法，从Spring容器中获取对象
        Client client = (Client) context.getBean("client");
        // 我们并没有给Client对象设置userService属性，userService的创建是由Spring帮我们完成的
        client.userService.add(new User(1001, "Jim"));
    }
}
