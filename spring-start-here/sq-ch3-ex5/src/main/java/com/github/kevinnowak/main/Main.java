package com.github.kevinnowak.main;

import com.github.kevinnowak.beans.Person;
import com.github.kevinnowak.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Person person = context.getBean(Person.class);

        System.out.printf("Person's name: %s\n", person.getName());
        System.out.printf("Person's parrot: %s\n", person.getParrot());
    }
}