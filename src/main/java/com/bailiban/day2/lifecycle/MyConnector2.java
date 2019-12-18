package com.bailiban.day2.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 通过实现InitializingBean接口，创建初始化烦方法
 * 实现DisposableBean接口，创建销毁方法
 */
public class MyConnector2 implements InitializingBean, DisposableBean {

    public MyConnector2() {
        System.out.println("MyConnector: 调用构造函数...");
    }

    public Object getConnection() {
        System.out.println("获取连接...");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("MyConnector: 调用销毁函，关闭连接，清除资源...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MyConnector: 调用初始化函数，创建连接...");
    }
}
