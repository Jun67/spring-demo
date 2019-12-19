package com.bailiban.day3.annotation.simple;

import java.util.Arrays;

// 使用自定义的注解，并设置value和locations属性
@MyAnnotation(value = "test", locations = {"a.xml", "b.properties"})
public class AnnotationTest {

    public static void main(String[] args) {
        // 获取注解
        MyAnnotation annotation = AnnotationTest.class.getAnnotation(MyAnnotation.class);
        // 访问并打印注解的value和locations属性
        System.out.println("value: " + annotation.value());
        System.out.println("locations:");
        Arrays.asList(annotation.locations()).forEach(System.out::println);
    }
}
