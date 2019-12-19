package com.bailiban.day3.spring_annotation.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("" +
                "com.bailiban.day3.spring_annotation.scope");
        // 每次从容器获取bean，都会得到一个新的实例
        System.out.println(context.getBean(User.class) == context.getBean(User.class)) ;
    }
}
