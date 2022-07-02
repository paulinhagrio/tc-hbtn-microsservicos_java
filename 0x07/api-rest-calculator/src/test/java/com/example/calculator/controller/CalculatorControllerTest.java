package com.example.calculator.controller;

import com.example.calculator.model.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    Calculator calculator;

   @Test
    void messageWelcome() throws Exception {
        RequestBuilder request = get("/calculator/welcome");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Bem vindo à CALCULATOR API REST.", result.getResponse().getContentAsString());
    }

    @Test
    void addNumbers() throws Exception {
        RequestBuilder request = get("/calculator/addNumbers")
                .param("n1", "600.0")
                .param("n2", "400.0");
       MvcResult result = mvc.perform(request).andReturn();
       assertEquals("1000.0", result.getResponse().getContentAsString());
    }

    @Test
    void subNumbers() throws Exception{
        RequestBuilder request = get("/calculator/subNumbers")
                .param("n1", "1000.0")
                .param("n2", "400.0");
       MvcResult result = mvc.perform(request).andReturn();
       assertEquals("600.0", result.getResponse().getContentAsString());
    }

    @Test
    void divideNumbers() throws Exception{
        RequestBuilder request = get("/calculator/divideNumbers")
                .param("n1", "1000.0")
                .param("n2", "2.0");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("500.0", result.getResponse().getContentAsString());

    }

    @Test
    void factorial() throws Exception{
        RequestBuilder request = get("/calculator/factorial")
                .param("factorial", "3");
       MvcResult result = mvc.perform(request).andReturn();
       assertEquals("6", result.getResponse().getContentAsString());
    }

    @Test
    void calculeDayBetweenDate() throws Exception{
        RequestBuilder request = get("/calculator/calculeDayBetweenDate")
                .param("localDate1", "2020-03-15")
                .param("localDate2", "2020-03-30");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("15", result.getResponse().getContentAsString());
    }

    @Test
    void integerToBinary() throws Exception{
        RequestBuilder request = get("/calculator/integerToBinary")
                .param("n1", "5");
       MvcResult result = mvc.perform(request).andReturn();
       assertEquals("101", result.getResponse().getContentAsString());

    }

    @Test
    void integerToHexadecimal() throws Exception{
        RequestBuilder request = get("/calculator/integerToHexadecimal")
                .param("n1", "170");
       MvcResult result = mvc.perform(request).andReturn();
       assertEquals("AA", result.getResponse().getContentAsString());
    }
}




