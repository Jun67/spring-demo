package com.bailiban.day3.annotation.datasource;

import javax.sql.DataSource;
import java.sql.Connection;

public class Client {

    public static void main(String[] args) throws Exception {
        DataSource dataSource = DataSourceFactory.getDataSource();
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
        conn.close();
    }
}
