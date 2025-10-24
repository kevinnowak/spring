package com.github.kevinnowak.controller;

import com.github.kevinnowak.model.Country;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @GetMapping("/france")
    public Country france() {
        return new Country("France", 67);
    }

    @GetMapping("/all")
    public List<Country> countries() {
        return List.of(
                new Country("France", 67),
                new Country("Spain", 47)
        );
    }
}
