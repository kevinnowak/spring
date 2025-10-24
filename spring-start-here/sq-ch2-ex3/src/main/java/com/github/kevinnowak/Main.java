package com.github.kevinnowak;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var parrot1 = context.getBean("parrot1", Parrot.class);
        System.out.println(parrot1.name());

        var parrot2 = context.getBean("parrot2", Parrot.class);
        System.out.println(parrot2.name());

        var parrot3 = context.getBean("parrot3", Parrot.class);
        System.out.println(parrot3.name());
    }
}