package com.bailiban.day1.mydi.fielddemo;

import com.bailiban.day1.helloworld.model.User;
import com.bailiban.day1.helloworld.service.UserService;

public class Client {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) throws Exception {
        // 通过xml文件，创建IOC容器
        BeanFactory.refresh("com/bailiban/day1/mydi/fielddemo/DI-field.xml");
        // 使用getBean方法，从自建的IOC容器中获取对象
        Client client = (Client) BeanFactory.getBean("client");
        // 我们并没有给Client对象设置userService属性，userService的创建是由IOC容器帮我们完成的
        client.userService.add(new User(1001, "Jim"));
    }
}
