package org.example.clientcontacts.service;

import lombok.RequiredArgsConstructor;
import org.example.clientcontacts.entity.Client;
import org.example.clientcontacts.entity.Email;
import org.example.clientcontacts.entity.Phone;
import org.example.clientcontacts.repo.ClientRepo;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

/**
 * @author Grigoriy Zemlyanskiy
 * @version 1.0
 * class ClientComponentImpl для работы с базой данных
 */
@RequiredArgsConstructor
@Component
public class ClientComponentImpl implements ClientComponent {

    private final ClientRepo repo;

    @Autowired
    private EmailComponent emailComponent;

    @Autowired
    private PhoneComponent phoneComponent;

    @Override
    public Optional<Client> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Client findByIdOrDie(Long id) throws Exception {
        Client client = repo.findById(id).orElseThrow(()->new RuntimeException("wrong id"));
        client.setEmails(emailComponent.findAllByClientId(client.getId()));
        client.setPhones(phoneComponent.findAllByClientId(client.getId()));
        return client;
    }

    @Override
    public List<Client> findAll() {
        return repo.findAll();
    }

    @Override
    public Client commit(Client client) {
        return repo.save(client);
    }

    @Override
    public Client create(String name) {

        if (!repo.findAllByClientName(name).isEmpty()){
            throw  new RuntimeException("клиент с данным именем уже существует!");
        }
        Client client = new Client();
        client.setName(name);
        return commit(client);
    }

    @Override
    public void addPhone(Long id,String phoneName)  throws Exception{
        Client client = findByIdOrDie(id);
        if (client.getPhones()!=null
                &&client
                .getPhones()
                .stream()
                .filter(el->el.getPhone().equals(phoneName)).count()>0){
            throw new RuntimeException(" клиент уже содержит данныый телефон!");
        }
        Phone phone = new Phone();
        phone.setPhone(phoneName);
        phone.setClient(client);
        client.getPhones().add(phone);
        commit(client);
    }

    @Override
    public void addEmail(Long id, String emailName) throws Exception{
        Client client =  findByIdOrDie(id);
        if (client.getEmails()!=null
                &&client
                .getEmails()
                .stream()
                .filter(el->el.getEmail().equals(emailName)).count()>0){
            throw  new RuntimeException(" клиент уже содержит данныый email!");
        }
        Email email = new Email();
        email.setEmail(emailName);
        email.setClient(client);
        client.getEmails().add(email);
        commit(client);
    }
}
