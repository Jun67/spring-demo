package com.bailiban.day3.spring_annotation.bean;

import org.springframework.stereotype.Component;

/**
 * @Component：指定类由Spring管理，相当于在xml中配置了一个bean；
 */
@Component
public class AccountService {

    void create() {
        System.out.println("创建账户成功。");
    }
}
