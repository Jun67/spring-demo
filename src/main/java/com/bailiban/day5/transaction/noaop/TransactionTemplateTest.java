package com.bailiban.day5.transaction.noaop;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

public class TransactionTemplateTest {

    static JdbcTemplate jt;
    static DruidDataSource dataSource;
    static {
        dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Shanghai");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        jt = new JdbcTemplate(dataSource);
    }

    static void queryTest() {
        jt.query("select * from book where isbn=1001", resultSet -> {
            System.out.println("isbn\tname\tprice");
            do {
                System.out.println(resultSet.getString(1) + "\t" +
                        resultSet.getString(2) + "\t" + resultSet.getInt(3));
            }while (resultSet.next());
        });
    }

    public static void main(String[] args) {

        TransactionTemplate tt = new TransactionTemplate(new DataSourceTransactionManager(dataSource));
        queryTest();
        tt.executeWithoutResult(status -> {
            try {
                jt.execute("update book set price=50 where isbn=1001");
                jt.execute("insert into book(isbn, book_name, price) values(1001, 100111, 10)");
            } catch (Exception e) {
                status.setRollbackOnly();
                System.out.println(e.getMessage());
            }
        });
        queryTest();
    }
}
