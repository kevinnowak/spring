package com.github.kevinnowak;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ProjectConfig {

    @Bean(name = "koko")
    Parrot parrot1() {
        return new Parrot("Koko");
    }

    @Bean(value = "miki")
    Parrot parrot2() {
        return new Parrot("Miki");
    }

    @Bean("riki")
    Parrot parrot3() {
        return new Parrot("Riki");
    }
}
