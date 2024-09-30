package org.example.clientcontacts.service;

import lombok.RequiredArgsConstructor;

import org.example.clientcontacts.entity.Phone;
import org.example.clientcontacts.repo.PhoneRepo;
import org.springframework.stereotype.Component;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Grigoriy Zemlyanskiy
 * @version 1.0
 * class PhoneComponentImpl
 */
@RequiredArgsConstructor
@Component
public class PhoneComponentImpl implements PhoneComponent{

    private final PhoneRepo repo;

    @Override
    public Set<Phone> findAllByClientId(Long id) {
        Set<Phone> phones = new HashSet<>();
        phones.addAll(repo.findAllByClientId(id).get());
        return phones;
    }

    @Override
    public Phone commit(Phone phone) {
        return repo.save(phone);
    }
}
