package com.bailiban.day2.beans;

import com.bailiban.day1.helloworld.model.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class Client {

    static ClassPathXmlApplicationContext context;
    static {
        context = new ClassPathXmlApplicationContext(
                "com/bailiban/day2/beans/beans.xml");
    }

    /**
     * name 属性
     */
    static void nameTest() {
        // 打印user的别名
        Arrays.asList(context.getAliases("user")).forEach(System.out::println);
        // 可以使用别名获取bean
        System.out.println(context.getBean("user") == context.getBean("user3"));
    }

    /**
     * scope 属性
     */
    static void scopeTest() {
        CounterTest1 counterTest1 = context.getBean(CounterTest1.class);
        counterTest1.count();
        counterTest1.count();
        CounterTest2 counterTest2 = context.getBean(CounterTest2.class);
        counterTest2.count();
        counterTest2.count();
    }

    /**
     * 构造函数注入，使用name
     */
    static void constructorByNameTest() {
        TestModel testModel = (TestModel) context.getBean("testModel1");
        System.out.println(testModel);
    }
    /**
     * 构造函数注入，使用index
     */
    static void constructorByIndexTest() {
        TestModel testModel = (TestModel) context.getBean("testModel2");
        System.out.println(testModel);
    }
    /**
     * 构造函数注入，使用type
     */
    static void constructorByTypeTest() {
        TestModel testModel = (TestModel) context.getBean("testModel3");
        System.out.println(testModel);
    }
    /**
     * 使用autowire属性
     */
    static void autowireTest() {
        CounterTest2 counterTest = (CounterTest2) context.getBean("counterTest3");
        counterTest.count();
    }

    static void collectionTest() {
        TestModel testModel = (TestModel) context.getBean("testModel4");
        System.out.println(testModel);
    }

    static void pTest() {
        User user = (User) context.getBean("user10");
        System.out.println(user);
    }

    public static void main(String[] args) {
//        nameTest();
//        scopeTest();
//        constructorByNameTest();
//        constructorByIndexTest();
//        constructorByTypeTest();
//        autowireTest();
//        collectionTest();
        pTest();
    }
}
