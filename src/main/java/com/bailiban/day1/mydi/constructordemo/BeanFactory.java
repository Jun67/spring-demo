package com.bailiban.day1.mydi.constructordemo;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanFactory {

    private static Map<String, Object> beanMap = new HashMap<>();

    public static void refresh(String xmlPath) throws Exception {
        // 创建SAXReader
        SAXReader saxReader = new SAXReader();
        // 获取xml配置文件
        URL xmlUrl = BeanFactory.class.getClassLoader().getResource(xmlPath);
        // 将SAXReader和xml配置文件绑定
        Document doc = saxReader.read(xmlUrl);
        // 获取根元素“beans”
        Element root = doc.getRootElement();
        // 遍历bean节点
        List<Element> beanElementList = root.elements();
        for (Element beanElement: beanElementList) {
            parseBeanElement(beanElement);
        }
    }

    private static void parseBeanElement(Element beanElement) throws Exception {
        String id = beanElement.attributeValue("id");
        String clsName = beanElement.attributeValue("class");
        // 获取Class对象
        Class<?> cls = Class.forName(clsName);
        // 获取构造参数节点
        List<Element> subElemList = beanElement.elements();
        // 如果没有构造参数，则直接调用无参构造函数
        if (subElemList.size() == 0) {
            // 获取无参构造函数
            Constructor<?> constructor = cls.getDeclaredConstructor();
            // 通过无参构造函数，实例化一个对象
            Object beanObj = constructor.newInstance();
            // 将bean对象存放到容器中
            beanMap.put(id, beanObj);
            return;
        }
        Class<?>[] parameterTypes = new Class[subElemList.size()];
        Object[] argsObject = new Object[subElemList.size()];
        int i = 0;
        for (Element subElem: subElemList) {
            String ref = subElem.attributeValue("ref");
            argsObject[i] = beanMap.get(ref);
            // 获取参数对象的接口，而不是类，因为构造函数中参数类型是接口
            parameterTypes[i] = argsObject[i].getClass().getInterfaces()[0];
            i++;
        }
        // 根据构造参数获取构造函数
        Constructor<?> constructor = cls.getDeclaredConstructor(parameterTypes);
        // 实例化对象，传入构造参数
        Object beanObj = constructor.newInstance(argsObject);
        beanMap.put(id, beanObj);
    }

    public static Object getBean(String beanId) {
        return beanMap.get(beanId);
    }
}
