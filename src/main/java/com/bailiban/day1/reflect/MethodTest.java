package com.bailiban.day1.reflect;

import com.bailiban.day1.helloworld.model.User;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class MethodTest {

    public static void main(String[] args) throws Exception {

        // 1. 获取User的类类型（类元数据信息）
        Class<?> cls = Class.forName("com.bailiban.day1.helloworld.model.User");

        // 2. 根据Class对象获取User的方法
        System.out.println("-----User的方法：");
        Method[] methods = cls.getDeclaredMethods();
        for (Method method: methods) {
            String modifier = Modifier.toString(method.getModifiers());
            System.out.print(modifier + " " + method.getName() + "(");
            // 获取对应构造函数的参数类型和名称
            String paramStr = "";
            Parameter[] parameters = method.getParameters();
            for (Parameter param: parameters) {
                paramStr += param.getType().getSimpleName() + " " + param.getName() + ", ";
            }
            if (!paramStr.equals(""))
                paramStr = paramStr.substring(0, paramStr.length()-2);
            System.out.println(paramStr + ");");
        }

        // 3. 使用反射调用方法
        System.out.println("-----使用反射调用方法：");
        User user = (User) cls.getConstructors()[0].newInstance();
        Method method = cls.getDeclaredMethod("setId", int.class);
        method.invoke(user, 1001);
        method = cls.getDeclaredMethod("setName", String.class);
        method.invoke(user, "Jim");
        System.out.println(user);
    }
}
