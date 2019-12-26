package com.bailiban.day5.transaction.transfer.annotation;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@EnableTransactionManagement // 开启事务管理
@Configuration  // 表示当前类为一个配置类
@ComponentScan("com.bailiban.day5.transaction.transfer.annotation")
@PropertySource("com/bailiban/day5/transaction/transfer/annotation/jdbc.properties") // 设置配置文件路径
public class AppConfig {

    // 从jdbc配置文件获取数据库连接属性
    @Value("${jdbc.jdbcUrl}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.driverClass}")
    private String driverClass;

    /**
     * 创建数据源bean
     */
    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClass);
        return dataSource;
    }

    /**
     * 创建JdbcTemplate，用于执行SQL语句；
     * @param dataSource 数据源参数，自动获取 @Bean("dataSource")
     */
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    /**
     * 创建事务管理器
     * @param dataSource
     * @return
     */
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
