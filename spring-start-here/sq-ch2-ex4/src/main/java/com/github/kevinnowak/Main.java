package com.github.kevinnowak;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var koko = context.getBean("koko", Parrot.class);
        System.out.println(koko.name());

        var miki = context.getBean("miki", Parrot.class);
        System.out.println(miki.name());

        var riki = context.getBean("riki", Parrot.class);
        System.out.println(riki.name());
    }
}