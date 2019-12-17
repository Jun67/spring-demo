package com.bailiban.day1.reflect;

import com.bailiban.day1.helloworld.model.User;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldTest {

    public static void main(String[] args) throws Exception {

        // 1. 获取User的类类型（类元数据信息）
        Class<?> cls = Class.forName("com.bailiban.day1.helloworld.model.User");

        // 2. 根据Class对象获取User的成员变量
        System.out.println("-----User的成员变量：");
        Field[] fields = cls.getDeclaredFields();
        for (Field field: fields) {
            String modifier = Modifier.toString(field.getModifiers());
            System.out.println(modifier + " " + field.getType().getSimpleName() + " " + field.getName() + ";");
        }

        // 3. 使用反射给属性赋值
        System.out.println("-----使用反射给属性赋值：");
        User user = (User) cls.getConstructors()[0].newInstance();
        Field field = cls.getDeclaredField("id");
        field.setAccessible(true);
        field.set(user, 1001);
        field = cls.getDeclaredField("name");
        field.setAccessible(true);
        field.set(user, "Jim");
        System.out.println(user);
    }
}
