package com.bailiban.day3.annotation.datasource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 运行时使用
@Target(ElementType.FIELD) // 该注解使用在属性字段上
public @interface Value {
    String value() default "";
}
