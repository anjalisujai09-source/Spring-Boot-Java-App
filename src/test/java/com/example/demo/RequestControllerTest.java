package com.example.demo;

import com.example.demo.Controller.RequestController;
import com.example.demo.Service.RequestService;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.security.test.context.support.WithMockUser;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RequestController.class)
class RequestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private RequestService requestService;

    @Test
    @WithMockUser
    void submitShouldReturn200() throws Exception {
        mockMvc.perform(post("/api/requests")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"payload\":\"test\"}"))
                .andExpect(status().isOk());
    }
}

