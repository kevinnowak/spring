package com.github.kevinnowak;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ProjectConfig {

    @Bean
    Parrot parrot1() {
        return new Parrot("Koko");
    }

    @Bean
    Parrot parrot2() {
        return new Parrot("Miki");
    }

    @Bean
    Parrot parrot3() {
        return new Parrot("Riki");
    }
}
