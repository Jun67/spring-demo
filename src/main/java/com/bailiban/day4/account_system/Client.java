package com.bailiban.day4.account_system;

import com.bailiban.day4.account_system.model.Account;
import com.bailiban.day4.account_system.service.ClientAccountService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Data
public class Client {

    @Autowired
    private ClientAccountService service;

    private boolean isLogin = false;
    private Account account = null;

    /**
     * 创建操作选项，分三种情况；
     * - 未登录时：
     *  1. 登录
     *  2. 退出
     * - 管理员账号：
     *  1. 退出
     *  2. 创建账户
     *  3. 删除账户
     *  4. 账户列表
     * - 普通用户账号：
     *  1. 退出
     *  2. 查询余额
     *  3. 取款
     *  4. 存款
     *  5. 转账
     */
    private String getClientInfo() {
        return (!isLogin ? "******欢迎使用BLB账户管理系统，请选择：******\r\n" :
                        "-----------------------------------------\r\n请选择：\r\n") +
                (!isLogin ? "\t1. 登录 \r\n\t2. 退出 \r\n" : "\t1. 退出\r\n") +
                (!isLogin ? "" : account.getRole().equals("管理员") ?
                        ("\t2. 创建账户\r\n" + "\t3. 删除账户\r\n" + "\t4. 账户列表\r\n") :
                        ("\t2. 查询余额\r\n" + "\t3. 取款\r\n" + "\t4. 存款\r\n" +
                                "\t5. 转账\r\n")) +
                "-----------------------------------------\r\n>> ";
    }

    /**
     * 账户管理系统运行入口函数
     */
    public void run() {
        // while循环，用户可以重复操作
        while (true) {
            boolean flag = true;
            Scanner scanner = new Scanner(System.in);
            // 打印操作选项
            System.out.print(getClientInfo());
            try {
                // 从终端输入获取操作选项
                int step = scanner.nextInt();
                // 判断是否为退出操作
                if (!isQuit(step)) {
                    // 登录系统
                    if (!isLogin && step == 1) {
                        login();
                    } else {
                        // 根据用户权限，执行管理员操作，或者普通用户操作
                        flag = account.getRole().equals("管理员") ? doAdmin(step) : doNormal(step);
                    }
                } else {
                    // 退出系统
                    System.out.println("~~Bye~~");
                    return;
                }
            } catch (Exception e) {
                flag = false;
            }
            if (!flag) {
                System.out.println("输入有误。");
            }
        }
    }

    /**
     * 普通用户操作
     * @param step 操作选项
     * @return flag 操作是否成功
     */
    private boolean doNormal(int step) {
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        double inputMoney = 0;  // 定义用户输入的金额
        try {
            switch (step) {
                case 2: // 2. 查询余额
                    System.out.println("账户余额为：" + account.getMoney());
                    break;
                case 3: // 3. 取款
                    flag = service.takeMoney(account);
                    break;
                case 4: // 4. 存款
                    flag = service.saveMoney(account);
                    break;
                case 5: // 5. 转账
                    flag = service.transfer(account);
                    break;
                default:  // 其他输入为非法选项
                    flag = false;
            }
        } catch (Exception e) {
            flag = false;
        }
        
        return flag;
    }

    /**
     * 管理员操作
     * @param step 操作选项
     * @return flag 操作是否成功
     */
    private boolean doAdmin(int step) {
        boolean flag = true;
        switch (step) {
            case 2: // 2. 创建账户
                flag = service.createAccount();
                break;
            case 3: // 3. 删除账户
                flag = service.deleteAccount();
                break;
            case 4: // 4. 账户列表
                service.getService().list();
                break;
            default: // 其他输入为非法选项
                flag = false;
        }
        return flag;
    }

    /**
     * 账户登录
     * @return 是否登录成功
     */
    private boolean login() {
        account = service.login();
        isLogin = account != null;
        return isLogin;
    }

    /**
     * 判断当前是否为退出操作
     * @param step 操作选项
     * @return true 退出
     */
    private boolean isQuit(int step) {
        // 当已登录时，step-1为退出选项；
        // 当未登录时，step-2为退出选项；
        return isLogin && step == 1 || !isLogin && step == 2;
    }

    public static void main(String[] args) {
        Client client = new AnnotationConfigApplicationContext(
                "com.bailiban.day4.account_system").getBean(Client.class);
        client.run();
    }
}
