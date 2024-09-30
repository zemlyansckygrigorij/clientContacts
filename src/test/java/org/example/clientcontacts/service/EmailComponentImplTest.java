package org.example.clientcontacts.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ContextConfiguration
@Transactional
class EmailComponentImplTest {
    @Autowired
    private EmailComponent component;

    @DisplayName("Проверка поиска всех email у данного клиента")
    @Test
    void findAllByClientId() {
        assertEquals(3,component.findAllByClientId(1L).size());
    }

    @DisplayName("Проверка поиска всех email у несуществующего клиента")
    @Test
    void findAllByClientNull() {
        assertEquals(0,component.findAllByClientId(4L).size());
    }
}