package com.ajitabh;

import com.ajitabh.entities.Game;
import com.ajitabh.entities.Team;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.NumberFormat;

public class RunDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("applicationContext.xml");

        Game game = context.getBean("game", Game.class);
        Team royals = context.getBean("royals", Team.class);
        Team redSox = context.getBean("redSox", Team.class);
        Team cubs = context.getBean("cubs", Team.class);

        game.setHomeTeam(royals);
        game.setAwayTeam(cubs);
        System.out.println(game.playGame());

        game.setHomeTeam(cubs);
        game.setAwayTeam(redSox);
        System.out.println(game.playGame());

        context.close();
    }
}
