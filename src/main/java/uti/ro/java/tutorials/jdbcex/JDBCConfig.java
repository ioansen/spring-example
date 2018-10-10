package uti.ro.java.tutorials.jdbcex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.*;

@Configuration
@EnableTransactionManagement
public class JDBCConfig {

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
    public EmployeeJDBCTemplate employeeJDBCTemplate(){
        return new EmployeeJDBCTemplate();
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(){
        DataSourceTransactionManager dtm = new DataSourceTransactionManager();
        dtm.setDataSource(dataSource());
        return dtm;
    }
}
