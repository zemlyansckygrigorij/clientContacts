package org.example.clientcontacts.controller.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.example.clientcontacts.entity.Client;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Данные полученные с контроллера о студенте.
 */

@Data
@Getter
@AllArgsConstructor
public class ClientResponse {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("phones")
    private Set<String> phones;

    @JsonProperty("emails")
    private Set<String> emails;
    public ClientResponse(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        if(client.getPhones()!=null){
            this.phones = new HashSet<>(client.getPhones().stream().map(el->el.getPhone()).collect(Collectors.toSet()));
        }
        if(client.getEmails()!=null){
            this.emails = new HashSet<>(client.getEmails().stream().map(el->el.getEmail()).collect(Collectors.toSet()));
        }

    }
}
