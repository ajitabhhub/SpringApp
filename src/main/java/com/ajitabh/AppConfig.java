package com.ajitabh;

import com.ajitabh.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

@Configuration
@Import({InfrastructureConfig.class})
public class AppConfig {
    @Autowired
    DataSource dataSource;

    @Bean
    public Game game() {
        BaseballGame baseballGame = new BaseballGame(redSox(), cubs());
        baseballGame.setDataSource(dataSource);
        System.out.println("dataSource = " + dataSource);
        return baseballGame;
    }
    @Bean
    public Team redSox() {
        return new RedSox();
    }

    @Bean
    public Team cubs() {
        return new Cubs();
    }
}
