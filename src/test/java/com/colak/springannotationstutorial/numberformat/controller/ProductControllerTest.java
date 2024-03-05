package com.colak.springannotationstutorial.numberformat.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testConvert() throws Exception {
        String url = "/api/product/get?price=1,000";

        ResultActions resultActions = mockMvc.perform(get(url));

        // The result is formatted as JSON
        resultActions
                .andExpect(status().isOk())
                .andExpect(content().string("{\"price\":1000}"));
    }
}
