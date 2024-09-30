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
class PhoneComponentImplTest {
    @Autowired
    private PhoneComponent component;

    @DisplayName("Проверка поиска всех телефонов у данного клиента")
    @Test
    void findAllByClientId() {
        assertEquals(2, component.findAllByClientId(1L).size());
    }
}