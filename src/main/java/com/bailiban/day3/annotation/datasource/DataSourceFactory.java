package com.bailiban.day3.annotation.datasource;

import com.alibaba.druid.pool.DruidDataSource;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.Properties;

public class DataSourceFactory {

    private static DruidDataSource dataSource = null;

    // 从jdbc配置文件获取数据库连接属性
    @Value("jdbcUrl")
    private static String jdbcUrl;
    @Value("username")
    private static String username;
    @Value("password")
    private static String password;
    @Value("driverClass")
    private static String driverClass;

    private static void setFields() {
        Properties properties = new Properties();
        try {
            properties.load(Objects.requireNonNull(DataSourceFactory.class.getClassLoader().getResourceAsStream(
                    "com/bailiban/day3/annotation/datasource/jdbc.properties")));
            Field[] fields = DataSourceFactory.class.getDeclaredFields();
            for (Field field : fields) {
                Value annotation = field.getAnnotation(Value.class);
                if (annotation == null) {
                    continue;
                }
                field.setAccessible(true);
                field.set(null, properties.getProperty(annotation.value()));
            }
        } catch (IOException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static DruidDataSource getDataSource() {
        if (dataSource == null) {
            setFields();
            dataSource = new DruidDataSource();
            dataSource.setUrl(jdbcUrl);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            dataSource.setDriverClassName(driverClass);
        }
        return dataSource;
    }
}
