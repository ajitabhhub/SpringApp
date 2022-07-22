package com.ajitabh;

import com.ajitabh.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.text.NumberFormat;
import java.util.List;

@Configuration
@Import(InfrastructureConfig.class)
@ComponentScan(basePackages = "com.ajitabh")
@EnableAspectJAutoProxy
public class AppConfig {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private List<Team> teams;

    @Bean
    public Game game() {
        BaseballGame baseballGame = new BaseballGame(teams.get(0), teams.get(1));
        baseballGame.setDataSource(dataSource);
        System.out.println("dataSource = " + dataSource);
        return baseballGame;
    }

    @Bean
    public NumberFormat nf() {
        return NumberFormat.getCurrencyInstance();
    }
}
