package com.bailiban.day3.spring_annotation.autowire.resource;

import com.bailiban.day3.spring_annotation.autowire.AccountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("client2")
public class Client {

    /**
     * 当有多个实例对象时，必须指定要注入的是哪一个对象
     * 注解@Resource可以替代 @Autowired + @Qualifier
     */
//    @Autowired
//    @Qualifier("accountService_setter")
    @Resource(name = "accountService_field")
    private AccountService accountService;

    public AccountService getAccountService() {
        return accountService;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                "com.bailiban.day3.spring_annotation.autowire");
        Client client = (Client) context.getBean("client2");
        client.getAccountService().create();
    }
}
