package com.ajitabh;

import com.ajitabh.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@ComponentScan (basePackages = "com.ajitabh")
public class AppConfig {
    @Autowired
    DataSource dataSource;

    @Resource
    Team redSox;

    @Resource
    Team cubs;

    @Bean
    public Game game() {
        BaseballGame baseballGame = new BaseballGame(redSox, cubs);
        baseballGame.setDataSource(dataSource);
        System.out.println("dataSource = " + dataSource);
        return baseballGame;
    }
}
