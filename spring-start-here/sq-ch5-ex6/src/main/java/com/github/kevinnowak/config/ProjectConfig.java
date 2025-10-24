package com.github.kevinnowak.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.github.kevinnowak.service", "com.github.kevinnowak.repository"})
public class ProjectConfig {
}
