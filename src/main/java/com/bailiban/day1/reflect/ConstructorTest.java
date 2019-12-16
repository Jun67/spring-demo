package com.bailiban.day1.reflect;

import com.bailiban.day1.helloworld.model.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class ConstructorTest {

    public static void main(String[] args) throws Exception {

        String className = "com.bailiban.day1.helloworld.model.User";

        // 1. 获取User的类类型（类元数据信息）
        Class<?> cls = Class.forName(className);

        // 2. 获取并遍历User所有构造函数
        System.out.println("--------获取并遍历User所有构造函数");
        Constructor<?>[] constructors = cls.getDeclaredConstructors();
        for (Constructor<?> cons: constructors) {
            // 获取限定符，这里全部是public
            String modifier = Modifier.toString(cons.getModifiers());
            System.out.print(modifier + " " + cls.getSimpleName() + "(");
            // 获取对应构造函数的参数类型和名称
            String paramStr = "";
            Parameter[] parameters = cons.getParameters();
            for (Parameter param: parameters) {
                paramStr += param.getType().getName() + " " + param.getName() + ", ";
            }
            if (!paramStr.equals(""))
                paramStr = paramStr.substring(0, paramStr.length()-2);
            System.out.println(paramStr + ");");
        }

        // 3. 通过无参构造函数，创建对象
        System.out.println("---------通过无参构造函数，创建对象");
        User user = (User) constructors[0].newInstance();
        user.setId(1001);
        user.setName("Jim");
        System.out.println(user);

        // 4. 通过有参构造函数，创建对象
        System.out.println("---------通过有参构造函数，创建对象");
        User user1 = (User) constructors[1].newInstance(1002, "David");
        System.out.println(user1);
    }
}
