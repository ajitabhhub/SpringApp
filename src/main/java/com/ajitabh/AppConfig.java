package com.ajitabh;

import com.ajitabh.entities.*;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.text.NumberFormat;

@Configuration
@Import(InfrastructureConfig.class)
@ComponentScan(basePackages = "com.ajitabh")
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public Game game(DataSource dataSource) {
        BaseballGame baseballGame = new BaseballGame(redSox(), cubs());
        baseballGame.setDataSource(dataSource);
        System.out.println("dataSource = " + dataSource);
        return baseballGame;
    }

    @Bean
    public NumberFormat nf() {
        return NumberFormat.getCurrencyInstance();
    }

    @Bean
    public Team redSox() {
        return new RedSox();
    }

    @Bean
    public Team cubs() {
        return new Cubs();
    }

    @Bean
    public Team royals() {
        return new Royals();
    }
}
