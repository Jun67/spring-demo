package com.bailiban.day2.lifecycle;

/**
 * xml配置：
 *  init-method="init" destroy-method="destroy"
 */
public class MyConnector {

    public MyConnector() {
        System.out.println("MyConnector: 调用构造函数...");
    }

    public void init() {
        System.out.println("MyConnector: 调用初始化函数，创建连接...");
    }

    public Object getConnection() {
        System.out.println("获取连接...");
        return null;
    }

    public void destroy() {
        System.out.println("MyConnector: 调用销毁函，关闭连接，清除资源...");
    }
}
