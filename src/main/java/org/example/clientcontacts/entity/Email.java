package org.example.clientcontacts.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Grigoriy Zemlyanskiy
 * @version 1.0
 * class Email для работы с таблицей email
 */
@Entity
@Table(name="email")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "email_id")
    private Long id;
    @Column(name="email")
    private String email;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
