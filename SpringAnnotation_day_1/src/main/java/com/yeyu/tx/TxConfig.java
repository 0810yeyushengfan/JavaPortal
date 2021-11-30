package com.yeyu.tx;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/*
1.导入相关依赖，比如数据源(此处用的是c3p0)，数据库驱动(这里用的是MySQL)和Spring-jdbc
2.配置数据源和JdbcTemplate(Spring提供的简化数据库操作的工具)的数据信息，并将它们加入到IOC容器中
3.给方法上标注@Transactional注解，表示当前方法是一个事务方法
4.在配置类上标注@EnableTransactionManagement注解，开启基于注解的事务管理功能
5.配置事务管理器来控制事务，并将它加入到IOC容器中
 */
@EnableTransactionManagement
@ComponentScan("com.yeyu.tx")
@Configuration
public class TxConfig {
    //配置数据源信息
    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("zyh769317.");
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        return dataSource;
    }

    //配置JdbcTemplate(Spring提供的简化数据库操作的工具)
    @Bean
    public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
        //Spring对@Configuration标注的配置类进行了特殊处理，在配置类的方法中，给容器中加组件的方法(即被@Bean注解标注的方法)
        //即使被多次调用，都只会是从容器中找组件，而不是每次调用都会创建一个新的组件
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate;
    }

    //在容器中注册事务管理器
    @Bean
    public PlatformTransactionManager transactionManager() throws PropertyVetoException {
        return new DataSourceTransactionManager(dataSource());
    }
}
