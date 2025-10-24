package com.github.kevinnowak.main;

import com.github.kevinnowak.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Supplier<Parrot> parrotSupplier1 = () -> {
            Parrot parrot = new Parrot();
            parrot.setName("Kiki");

            return parrot;
        };

        Supplier<Parrot> parrotSupplier2 = () -> {
            Parrot parrot = new Parrot();
            parrot.setName("Koko");

            return parrot;
        };

        context.registerBean("parrot1", Parrot.class, parrotSupplier1, bd -> bd.setPrimary(true));
        context.registerBean("parrot2", Parrot.class, parrotSupplier2);

        System.out.println(context.getBean("parrot1", Parrot.class).getName());
        System.out.println(context.getBean("parrot2", Parrot.class).getName());
    }
}