package com.github.kevinnowak.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.github.kevinnowak.service", "com.github.kevinnowak.aspect"})
@EnableAspectJAutoProxy
public class ProjectConfig {
}
