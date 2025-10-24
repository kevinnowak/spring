package com.github.kevinnowak.config;

import com.github.kevinnowak.beans.Parrot;
import com.github.kevinnowak.beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    public Parrot parrot() {
        Parrot p = new Parrot();
        p.setName("Koko");

        return p;
    }

    @Bean
    public Person person() {
        Person p = new Person();
        p.setName("Ella");

        return p;
    }
}
