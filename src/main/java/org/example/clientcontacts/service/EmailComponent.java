package org.example.clientcontacts.service;

import org.example.clientcontacts.entity.Email;
import java.util.Set;

/**
 * @author Grigoriy Zemlyanskiy
 * @version 1.0
 * interface EmailComponent
 */
public interface EmailComponent {


    /**
     * Сохраняет email.
     *
     * @param email email для сохранения.
     * @return сохраненный email.
     */
    Email commit(Email email);
    /**
     * Находит всех email.
     *
     * @return список email.
     */
    Set<Email> findAllByClientId(Long id);
}
