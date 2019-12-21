package com.bailiban.day4.account_system.dao;

import com.bailiban.day4.account_system.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
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
     * account表字段和Account类映射关系类
     */
    static class AccountRowMapping implements RowMapper<Account> {
        @Override
        public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            double money = rs.getDouble(3);
            String role = rs.getString(4);
            return new Account(id, name, "", money, role);
        }
    }

    /**
     * 根据id查找用户
     */
    @Override
    public Account findById(int id) {
        try {
            return jdbcTemplate.queryForObject("select id, name, money, role from account where id = ?",
                    new AccountDaoImpl.AccountRowMapping(), id);
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
                    new AccountDaoImpl.AccountRowMapping(), name);
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
                    new AccountDaoImpl.AccountRowMapping(), name, password);
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
                    new AccountDaoImpl.AccountRowMapping());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
