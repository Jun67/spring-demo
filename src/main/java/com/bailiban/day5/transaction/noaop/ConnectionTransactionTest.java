package com.bailiban.day5.transaction.noaop;

import java.sql.*;

public class ConnectionTransactionTest {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String url="jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8";
    public static String username = "root";
    public static String password = "root";

    static void queryTest() throws SQLException {
        System.out.println("============queryTest==============");
        Connection conn = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = conn.prepareStatement("select * from book where isbn=1001");
        ResultSet rs = statement.executeQuery();
        System.out.println("isbn\tname\tprice");
        while (rs.next()) {
            System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3));
        }
        rs.close();
        statement.close();
        conn.close();
    }

    static void noTransactionTest() {
        System.out.println("============noTransactionTest==============");
        Connection conn = null;
        Statement statement = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            statement = conn.createStatement();
            statement.execute("update book set price=150 where isbn=1001");
            statement.execute("insert into book(isbn, book_name, price) values(1001, 100111, 10)");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                statement.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    static void transactionTest() {
        System.out.println("============transactionTest==============");
        Connection conn = null;
        Statement statement = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            conn.setAutoCommit(false);
            statement = conn.createStatement();
            statement.execute("update book set price=150 where isbn=1001");
            statement.execute("insert into book(isbn, book_name, price) values(1001, 100111, 10)");
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
                System.out.println(e.getMessage());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                statement.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        queryTest();
//        noTransactionTest();
        transactionTest();
        queryTest();
    }
}
