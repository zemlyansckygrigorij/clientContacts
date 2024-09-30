package org.example.clientcontacts.service;

import org.example.clientcontacts.entity.Client;
import org.example.clientcontacts.entity.Email;
import org.example.clientcontacts.entity.Phone;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ContextConfiguration
@Transactional
class ClientComponentImplTest {
    @Autowired
    private ClientComponent component;

    @DisplayName("Проверка поиска клиента по идентификатору.")
    @Test
    void findById() {
        assertEquals("michael",component.findById(1L).get().getName());
    }

    @DisplayName("Проверка имени в поиска клиента по идентификатору.")
    @Test
    void findByIdOrDieCheckName() throws Exception {
        assertEquals("michael",component.findByIdOrDie(1L).getName());
    }

    @DisplayName("Проверка телефона в поиска клиента по идентификатору.")
    @Test
    void findByIdOrDieCheckPhone() throws Exception {
        assertEquals(3,component.findByIdOrDie(1L).getPhones().size());
    }

    @DisplayName("Проверка поиска всех клиентов")
    @Test
    void findAll() {
        assertEquals(2,component.findAll().size());
    }

    @DisplayName("Проверка создания клиента.")
    @Test
    void commit() throws Exception {
        Client client = new Client();
        client.setName("test");
        Client clientTable = component.findByIdOrDie(component.commit(client).getId());
        assertEquals("test",clientTable.getName());
    }

    @DisplayName("Проверка сохранения клиента с email.")
    @Test
    void commitWithEmails() throws Exception {
        Client client = new Client();
        client.setName("test");
        Client clientTable = component.findByIdOrDie(component.commit(client).getId());
        Email email = new Email();
        email.setEmail("Test@test.com");
        email.setClient(clientTable);
        clientTable.getEmails().add(email);
        component.commit(clientTable);
        assertEquals(1,component.commit(clientTable).getEmails().size());
    }

    @DisplayName("Проверка сохранения клиента с телефоном.")
    @Test
    void commitWithPhones() throws Exception {
        Client client = new Client();
        client.setName("test");
        Client clientTable = component.findByIdOrDie(component.commit(client).getId());
        Phone phone = new Phone();
        phone.setPhone("123-34-56");
        phone.setClient(clientTable);
        clientTable.getPhones().add(phone);
        component.commit(clientTable);
        assertEquals(1,component.commit(clientTable).getPhones().size());
    }
}