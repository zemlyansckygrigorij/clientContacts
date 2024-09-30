package org.example.clientcontacts.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import java.util.Set;

/**
 * @author Grigoriy Zemlyanskiy
 * @version 1.0
 * class Client для работы с таблицей clients
 */
@Entity
@Table(name="clients")
@Getter
@Setter
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "client_id")
    private Long id;
    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.TRUE)
    @JoinColumn(name = "client_id")
    Set<Phone> phones;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.TRUE)
    @JoinColumn(name = "client_id")
    Set<Email> emails;

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
