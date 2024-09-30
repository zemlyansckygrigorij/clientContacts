package org.example.clientcontacts.service;

import lombok.RequiredArgsConstructor;
import org.example.clientcontacts.entity.Email;
import org.example.clientcontacts.repo.EmailRepo;
import org.springframework.stereotype.Component;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Grigoriy Zemlyanskiy
 * @version 1.0
 *class EmailComponentImpl для работы с базой данных
 */
@RequiredArgsConstructor
@Component
public class EmailComponentImpl implements EmailComponent{
    private final EmailRepo repo;
    @Override
    public Email commit(Email email) {
        return repo.save(email);
    }

    @Override
    public Set<Email> findAllByClientId(Long id) {
        Set<Email>emails = new HashSet<>();
        emails.addAll(repo.findAllByClientId(id).get());
        return emails;
    }
}
