package com.github.kevinnowak;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.github.kevinnowak.model.Country;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MainTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetFrance() throws Exception {
        var mapper = new ObjectMapper();
        Country france = new Country("France", 67);
        var expected = mapper.writeValueAsString(france);
        mockMvc.perform(get("/france"))
                .andExpect(status().isOk())
                .andExpect(content().json(expected));
    }

    @Test
    public void testGetAllCountries() throws Exception {
        var mapper = new ObjectMapper();
        var allCountries = List.of(
                new Country("France", 67),
                new Country("Spain", 47)
        );
        var expected = mapper.writeValueAsString(allCountries);
        mockMvc.perform(get("/all"))
                .andExpect(status().isOk())
                .andExpect(content().json(expected));
    }
}
