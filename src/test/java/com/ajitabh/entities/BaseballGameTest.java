package com.ajitabh.entities;

import com.ajitabh.config.AppConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BaseballGameTest {
    private static Game game;

    private static ApplicationContext ctx;

    @BeforeAll
    public static void setUp() {
        ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        game = ctx.getBean("game", Game.class);
        System.out.println("Before All");
    }

    @Test
    public void testHello() {
        System.out.println("Hello");
        System.out.println(game);
        System.out.println(ctx);


        String away = game.getAwayTeam().getName();
        String home = game.getHomeTeam().getName();

        String results = game.playGame();

        assertTrue(results.contains(away) | results.contains(home));
    }

    @Test
    public void testGetAndSetHome() {
        Team royals = ctx.getBean("royals", Team.class);
        game.setHomeTeam(royals);
        assertEquals(royals.getName(), game.getHomeTeam().getName());
    }
}
