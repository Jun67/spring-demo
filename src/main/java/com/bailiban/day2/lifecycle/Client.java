package com.bailiban.day2.lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    /**
     * 在xml文件中配置初始化和销毁方法
     *  init-method="init" destroy-method="destroy"
     */
    static void xmlTest() {
        // 在初始化Spring容器的时候，会创建MyConnector类
        // 并调用其构造函数和初始化函数
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "com/bailiban/day2/lifecycle/lifecycle.xml");

        // 获取MyConnector对象，并调用相关方法。
        // 注意：MyConnector对象不是在getBean方法中创建的，而是在Spring初始化时已被创建
        context.getBean(MyConnector.class).getConnection();

        // 关闭Spring容器，bean的销毁方法会被执行
        context.close();
    }

    /**
     * 通过实现InitializingBean接口，创建初始化方法
     * 实现DisposableBean接口，创建销毁方法
     */
    static void interfaceTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "com/bailiban/day2/lifecycle/lifecycle.xml");
        context.getBean(MyConnector2.class).getConnection();
        context.close();
    }

    /**
     * 基于注解的初始化方法和销毁方法
     */
    static void annotationTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "com/bailiban/day2/lifecycle/lifecycle.xml");
        context.getBean(MyConnector3.class).getConnection();
        context.close();
    }

    public static void main(String[] args) {
        xmlTest();
//        interfaceTest();
//        annotationTest();
    }
}
