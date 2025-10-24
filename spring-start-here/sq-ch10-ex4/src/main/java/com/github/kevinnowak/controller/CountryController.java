package com.github.kevinnowak.controller;

import com.github.kevinnowak.model.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @GetMapping("/france")
    public ResponseEntity<Country> france() {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("continent", "Europe")
                .header("capital", "Paris")
                .header("favorite_food", "cheese and wine")
                .body(new Country("France", 67));
    }

    @GetMapping("/all")
    public List<Country> countries() {
        return List.of(
                new Country("France", 67),
                new Country("Spain", 47)
        );
    }
}
