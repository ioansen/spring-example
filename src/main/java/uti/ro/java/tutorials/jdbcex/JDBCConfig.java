package uti.ro.java.tutorials.jdbcex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.*;

@Configuration
@EnableTransactionManagement
@ComponentScan("uti.ro.java.tutorials.jdbcex")
public class JDBCConfig {

    /*@Bean
    public EmpJDBCTemplate employeeJDBCTemplate(){
        return new EmpJDBCTemplate(dataSource());
    }*/

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/EMP?autoReconnect=true&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("test");

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }
}
