package com.bailiban.day4.aop.aopxml.transaction;

import com.bailiban.day4.account_system.model.Account;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDao {

    public void update(Account account) throws SQLException {
        String sql = "update account set money = " + account.getMoney() + " where id = " + account.getId();
        JdbcUtil.statement.execute(sql);
    }

    public Account findById(int id) {
        Account account = null;
        try (ResultSet rs = JdbcUtil.statement.executeQuery("select id, name, money from account where id=" + id)) {
            if (rs.next()) {
                account = new Account(rs.getInt(1), rs.getString(2),
                        "", rs.getDouble(3), "");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

}
