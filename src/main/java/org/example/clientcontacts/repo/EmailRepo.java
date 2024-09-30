package org.example.clientcontacts.repo;

import org.example.clientcontacts.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;
import java.util.Set;

/**
 * @author Grigoriy Zemlyanskiy
 * @version 1.0
 * interface EmailRepo для работы с таблицей email
 */
public interface EmailRepo  extends JpaRepository<Email, Long> {
    @Query(value
            = "select * "
            + "from email  "
            + "where client_id = :id",
            nativeQuery = true)
    Optional<Set<Email>> findAllByClientId(@Param("id")Long id);
}
