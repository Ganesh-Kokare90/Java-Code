package com.springjdbc.util;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

import static com.springjdbc.constants.DbConstants.*;

@Configuration
@PropertySource(value = "application.properties")

@ComponentScan(basePackages = {"com.springjdbc"})
@AllArgsConstructor


public class SpringConfiguration {


    Environment environment;
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(environment.getProperty("mysql.dev.url"));
        dataSource.setUsername(environment.getProperty("mysql.dev.username"));
        dataSource.setPassword(environment.getProperty("mysql.dev.password"));
        dataSource.setDriverClassName(environment.getProperty("mysql.dev.driver.class"));
        return  dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

}
