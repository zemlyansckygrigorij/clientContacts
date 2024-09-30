package org.example.clientcontacts.controller;

import lombok.RequiredArgsConstructor;
import org.example.clientcontacts.controller.model.response.ClientResponse;
import org.example.clientcontacts.service.ClientComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Grigoriy Zemlyanskiy
 * @version 1.0
 * class ClientController
 * для работы с web сайтом /client
 */

@RestController
@Validated
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    @Autowired
    private ClientComponent component;

    @GetMapping()
    public List<ClientResponse> getAllClients() {
        return component.findAll().stream().map(el-> new ClientResponse(el)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ClientResponse getClientById(
            @PathVariable(name = "id") final long id
    ) throws Exception {
        return new ClientResponse(component.findByIdOrDie(id));
    }

    @PostMapping()
    public ClientResponse createClient(@RequestBody String name) throws Exception {
        return new ClientResponse(component.create(name));
    }

    @PostMapping("/{id}/phone")
    public void addPhoneByClient(
            @PathVariable(name = "id") final long id,
            @RequestBody String phone) throws Exception {
        component.addPhone(id,phone);
    }

    @PostMapping("/{id}/email")
    public void addEmailByClient(
            @PathVariable(name = "id") final long id,
            @RequestBody String email) throws Exception {
        component.addEmail(id,email);
    }

    @GetMapping("/{id}/phones")
    public Set<String> getAllPhonesByClientId(
            @PathVariable(name = "id") final long id
    ) throws Exception {
        return new ClientResponse(component.findByIdOrDie(id)).getPhones();
    }

    @GetMapping("/{id}/emails")
    public Set<String> getAllEmailsByClientId(
            @PathVariable(name = "id") final long id
    ) throws Exception {
        return new ClientResponse(component.findByIdOrDie(id)).getEmails();
    }

    @GetMapping("/{id}/contact")
    public Set<String> getAllContactsByClientId(
            @PathVariable(name = "id") final long id
    ) throws Exception {
        ClientResponse response = new ClientResponse(component.findByIdOrDie(id));
        Set<String> contacts = new HashSet<>();
        contacts.addAll(response.getEmails());
        contacts.addAll(response.getPhones());
        return contacts;
    }
}
