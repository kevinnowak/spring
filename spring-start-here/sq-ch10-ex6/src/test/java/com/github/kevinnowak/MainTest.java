package com.github.kevinnowak;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.kevinnowak.exception.NotEnoughMoneyException;
import com.github.kevinnowak.model.ErrorDetails;
import com.github.kevinnowak.model.PaymentDetails;
import com.github.kevinnowak.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MainTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PaymentService paymentService;

    @Test
    void testMakePaymentSuccessful() throws Exception {
        var mapper = new ObjectMapper();
        var paymentDetails = new PaymentDetails(1_000);
        when(paymentService.processPayment()).thenReturn(paymentDetails);
        var expected = mapper.writeValueAsString(paymentDetails);
        mockMvc.perform(post("/payment")).andExpect(status().isAccepted()).andExpect(content().json(expected));
    }

    @Test
    void testMakePaymentNotEnoughMoney() throws Exception {
        var mapper = new ObjectMapper();
        var errorDetails = new ErrorDetails("Not enough money to make the payment");
        when(paymentService.processPayment()).thenThrow(new NotEnoughMoneyException());
        var expected = mapper.writeValueAsString(errorDetails);
        mockMvc.perform(post("/payment")).andExpect(status().isBadRequest()).andExpect(content().json(expected));
    }
}
