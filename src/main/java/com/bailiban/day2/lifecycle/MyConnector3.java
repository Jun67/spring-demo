package com.bailiban.day2.lifecycle;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 基于注解的初始化方法和销毁方法
 */
@Component
public class MyConnector3 {

    public MyConnector3() {
        System.out.println("MyConnector: 调用构造函数...");
    }

    public Object getConnection() {
        System.out.println("获取连接...");
        return null;
    }

    @PreDestroy
    public void destroy() {
        System.out.println("MyConnector: 调用销毁函，关闭连接，清除资源...");
    }

    @PostConstruct
    public void init() throws Exception {
        System.out.println("MyConnector: 调用初始化函数，创建连接...");
    }
}
