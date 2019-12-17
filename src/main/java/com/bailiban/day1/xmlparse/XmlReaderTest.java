package com.bailiban.day1.xmlparse;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class XmlReaderTest {

    static void parseElement(Element element) {
        System.out.println("标签名：" + element.getName());
        System.out.println("属性：");
        Iterator<Attribute> attributeIterator = element.attributeIterator();
        while (attributeIterator.hasNext()) {
            Attribute attribute = attributeIterator.next();
            System.out.println(attribute.getName() + ": " + attribute.getValue());
        }
        List<Element> subElementList = element.elements();
        if (subElementList.size() > 0) {
            System.out.println("子标签：");
        }
        for (Element subElement: subElementList) {
            parseElement(subElement);
        }
    }

    public static void main(String[] args) throws Exception {

        SAXReader reader = new SAXReader();
        URL xmlUrl = XmlReaderTest.class.getClassLoader().getResource("applicationContext.xml");
        Document doc =  reader.read(xmlUrl);
        Element rootEle = doc.getRootElement();
        System.out.println("root Element: " + rootEle.getName());

        Iterator<Element> iterator = rootEle.elementIterator();
        while (iterator.hasNext()) {
            parseElement(iterator.next());
        }
    }
}
