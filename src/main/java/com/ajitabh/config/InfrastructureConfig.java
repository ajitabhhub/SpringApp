package com.ajitabh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class InfrastructureConfig {
    @Bean
    public DataSource dataSource() {
        System.out.println("Invoking DataSource");
        return new DriverManagerDataSource();
    }
}
