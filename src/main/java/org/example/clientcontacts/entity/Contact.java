package org.example.clientcontacts.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="contacts")
@Getter
@Setter
public class Contact {
    @Id
    private Long id;
    @Column(name="contact")
    private String contact;

    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact )) return false;
        return contact != null && contact.equals(((Contact) o).getContact());
    }

    @Override
    public int hashCode() {
        return contact.hashCode();
    }
}
