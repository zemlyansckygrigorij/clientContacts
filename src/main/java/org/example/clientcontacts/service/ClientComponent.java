package org.example.clientcontacts.service;

import org.example.clientcontacts.entity.Client;

import java.util.List;
import java.util.Optional;
/**
 * @author Grigoriy Zemlyanskiy
 * @version 1.0
 * interface ClientComponent
 */
public interface ClientComponent {
    /**
     * Ищет клиента по идентификатору.
     *
     * @param id идентификатор клиента.
     * @return клиент .
     */
    Optional<Client> findById(Long id);

    /**
     * Ищет клиента по идентификатору и падает по ошибке, если не нашел.
     *
     * @param id идентификатор клиента.
     * @return клиент.
     */
    Client findByIdOrDie(Long id) throws Exception;

    /**
     * Находит всех клиентов.
     *
     * @return список клиентов.
     */
    List<Client> findAll();

    /**
     * Сохраняет клиента.
     *
     * @param client клиента.
     * @return сохраненный клиента.
     */
    Client commit(Client client);
    /**
     * Создает клиента.
     *
     * @param name имя клиента.
     * @return сохраненный клиента.
     */
    Client create(String name);
    /**
     *Добавляет телефон клиенту.
     *
     * @param  phone номер.
     */
    void addPhone(Long id,String phone) throws Exception;
    /**
     *Добавляет email клиенту.
     *
     * @param  emailName email.
     */
    void addEmail(Long id, String emailName) throws Exception;
}