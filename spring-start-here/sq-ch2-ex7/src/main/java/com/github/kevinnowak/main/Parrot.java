package com.github.kevinnowak.main;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class Parrot {

    private String name;

    @PostConstruct
    public void init() {
        this.name = "Kiki";
    }

    public String getName() {
        return name;
    }
}
