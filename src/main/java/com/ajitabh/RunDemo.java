package com.ajitabh;

import com.ajitabh.entities.Game;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.NumberFormat;

public class RunDemo {
    public static void main(String[] args) {
//        ApplicationContext context =
//                new AnnotationConfigApplicationContext(AppConfig.class);
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        NumberFormat nf = context.getBean("nf", NumberFormat.class);
        double amount = 12345678.9012345;
        System.out.println(nf.format(amount));

//        Game game = context.getBean("game", Game.class);
//        System.out.println(game.playGame());
//
//        System.out.println("There are " + context.getBeanDefinitionCount());
//        for (String name : context.getBeanDefinitionNames()) {
//            System.out.println("name = " + name);
//        }
    }
}
