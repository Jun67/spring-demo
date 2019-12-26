package com.bailiban.day4.account_system.dao;

import com.bailiban.day4.account_system.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 创建新用户
     */
    @Override
    public boolean create(Account account) {
        String name = account.getName();
        // 判断用户是否已存在
        if (findByName(name) != null) {
            System.out.println("账户 " + name + " 已存在。");
            return false;
        }
        jdbcTemplate.update("insert into account(name, password, money) values(?, ?, ?)",
                name, account.getPassword(), account.getMoney());
        return true;
    }

    /**
     * 更新账号余额
     */
    @Override
    public void update(Account account) {
        jdbcTemplate.update("update account set money = ? where id = ?",
                account.getMoney(), account.getId());
    }

    /**
     * 删除用户
     */
    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from account where id = ?", id);
    }

    /**
     * 根据id查找用户
     */
    @Override
    public Account findById(int id) {
        try {
            return jdbcTemplate.queryForObject("select id, name, money, role from account where id = ?",
                    new AccountRowMapping(), id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    /**
     * 根据用户名查找用户
     */
    @Override
    public Account findByName(String name) {
        try {
            return jdbcTemplate.queryForObject("select id, name, money, role from account where name = ?",
                    new AccountRowMapping(), name);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    /**
     * 用户登录
     */
    @Override
    public Account accountLogin(String name, String password) {
        try {
            return jdbcTemplate.queryForObject("select id, name, money, role from account where name = ? and password = ?",
                    new AccountRowMapping(), name, password);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    /**
     * 返回用户列表
     */
    @Override
    public List<Account> findAll() {
        try {
            return jdbcTemplate.query("select id, name, money, role from account",
                    new AccountRowMapping());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
