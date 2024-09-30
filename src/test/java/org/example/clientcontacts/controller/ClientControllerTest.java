package org.example.clientcontacts.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.example.clientcontacts.service.ClientComponent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Transactional
class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @LocalServerPort
    private int port;

    @DisplayName("Проверка поиска всех клиентов")
    @Test
    void getAllClients() throws Exception {
        mockMvc.perform(get("http://localhost:" + port + "/client"))
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @DisplayName("Проверка поиска клиента по идентификатору.")
    @Test
    void getClientById() throws Exception {
        this.mockMvc.perform(get("/client/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("michael")))
                .andExpect(jsonPath("$.phones", hasSize(3)))
                .andExpect(jsonPath("$.emails", hasSize(3)));
    }

    @DisplayName("Проверка поиска всех телефонов данного клиента")
    @Test
    void getAllPhonesByClientId() throws Exception {
        mockMvc.perform(get("http://localhost:" + port + "/client/1/phones"))
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @DisplayName("Проверка поиска всех email данного клиента")
    @Test
    void getAllEmailsByClientId() throws Exception {
        mockMvc.perform(get("http://localhost:" + port + "/client/1/emails"))
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @DisplayName("Проверка поиска всех контактов данного клиента")
    @Test
    void getAllContactsByClientId() throws Exception {
        mockMvc.perform(get("http://localhost:" + port + "/client/1/contacts"))
                .andExpect(jsonPath("$", hasSize(3)));
    }
}