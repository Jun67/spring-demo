package com.bailiban.day4.account_system.service;

import com.bailiban.day4.account_system.model.Account;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

/**
 * 对AccountService做一些封装，主要添加了从终端获取用户输入的功能
 * 该类包含一个AccountService的成员属性
 */
@Service
@Data
public class ClientAccountService {

    @Autowired
    private AccountService service;

    /**
     * 登录
     * @return account 成功则返回账户
     */
    public Account login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String name = scanner.next();
        System.out.print("请输入密码：");
        String password = scanner.next();

        // 登录，并返回账户信息
        Account account = service.login(name, password);
        if (account == null) {
            System.out.println("用户名或密码有误，请重新输入。");
        } else {
            System.out.println("登录成功，欢迎 " + account.getName() + " !");
        }
        return account;
    }

    /**
     * 根据用户输入，创建账户
     * @return flag 是否创建成功
     */
    public boolean createAccount() {
        boolean flag = true;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("请输入用户名：");
            String name = scanner.next();
            System.out.print("请输入密码：");
            String password = scanner.next();
            System.out.print("请输入初始金额：");
            double money = scanner.nextDouble();
            Account account = new Account(0, name, password, money, "");
            flag = service.createAccount(account);
            // 创建失败，返回false
            if (!flag)
                return false;
            System.out.println("账户创建成功，账户信息：" + account);
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 删除账户
     */
    public boolean deleteAccount() {
        boolean flag = true;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("请输入待删除的账户ID：");
            int id = scanner.nextInt();
            service.deleteAccount(id);
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 存钱
     */
    public boolean saveMoney(Account account) {
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入存款金额：");
        try {
            double inputMoney = scanner.nextDouble();
            flag = service.saveMoney(account, inputMoney);
            if (flag)
                System.out.println("成功存入" + inputMoney + "，当前余额为：" + account.getMoney());
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 取钱
     */
    public boolean takeMoney(Account account) {
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入取款金额：");
        try {
            double inputMoney = scanner.nextDouble();
            flag = service.takeMoney(account, inputMoney);
            if (flag)
                System.out.println("成功取款" + inputMoney + "，当前余额为：" + account.getMoney());
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 转账操作
     */
    public boolean transfer(Account account) {
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入转出金额：");
        try {
            double inputMoney = scanner.nextDouble();
            // 判断余额是否充足
            if (inputMoney > account.getMoney()) {
                System.out.println("余额不足，当前余额为：" + account.getMoney());
                return false;
            }
            System.out.print("请输入转账账户ID：");
            int toId = scanner.nextInt();
            // 判断转出账户是否存在
            if (service.findById(toId) == null) {
                System.out.println("ID为：" + toId + "的账户不存在。");
                return false;
            }

            // 转账，更新数据库信息
            flag = service.transfer(account.getId(), toId, inputMoney);
            if (flag) {
                // 更新余额
                account.setMoney(account.getMoney() - inputMoney);
                System.out.println("转账成功，当前余额为：" + account.getMoney());
            }
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }
}
