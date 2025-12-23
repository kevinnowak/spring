package com.github.kevinnowak.date4u;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {Date4uApplication.class}, lazyInit = true)
class Date4uConfiguration {
}
