package com.github.kevinnowak.main;

import com.github.kevinnowak.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot p = context.getBean(Parrot.class);
        p.setName("Goofy");
        System.out.println(p);
        System.out.println(p.getName());
    }
}