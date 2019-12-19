package com.bailiban.day3.annotation.simple;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 运行时可以访问该注解
@Target(ElementType.TYPE)   // 该注解使用在类上
public @interface MyAnnotation {

    String value() default "默认值";

    String[] locations() default {};
}
