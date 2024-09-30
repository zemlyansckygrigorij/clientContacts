package org.example.clientcontacts.repo;

import org.example.clientcontacts.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.Set;

/**
 * @author Grigoriy Zemlyanskiy
 * @version 1.0
 * interface ClientRepo для работы с таблицей clients
 */
@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {
    @Query(value
            = "select * "
            + "from clients  "
            + "where name = :name",
            nativeQuery = true)
    Optional<Set<Client>> findAllByClientName(@Param("name")String name);
}
