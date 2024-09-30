package org.example.clientcontacts.service;

import org.example.clientcontacts.entity.Phone;
import java.util.Set;
/**
 * @author Grigoriy Zemlyanskiy
 * @version 1.0
 * interface PhoneComponent
 */
public interface PhoneComponent {

    /**
     * Находит всех телефоны данного клиента.
     *
     * @return список телефонов .
     */
    Set<Phone> findAllByClientId(Long id);
    /**
     * Сохраняет телефон.
     *
     * @param phone телефон для сохранения.
     * @return сохраненный телефон.
     */
    Phone commit(Phone phone);
}
