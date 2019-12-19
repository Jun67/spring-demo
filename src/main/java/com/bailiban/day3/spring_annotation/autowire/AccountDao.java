package com.bailiban.day3.spring_annotation.autowire;

import org.springframework.stereotype.Repository;

/**
 * @Repository：一般用于持久层（数据库相关操作）；
 */
@Repository
public class AccountDao {

    public void create() {
        System.out.println("创建账户成功。");
    }
}
