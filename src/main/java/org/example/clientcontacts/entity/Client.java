package org.example.clientcontacts.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name="clients")
@Getter
@Setter
public class Client {
    @Id
    private Long id;
    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "contact_id")
    Set<Contact> contacts;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client )) return false;
        return name != null && name.equals(((Client) o).getName());
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
 }
