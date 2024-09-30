package org.example.clientcontacts.repo;

import org.example.clientcontacts.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;
import java.util.Set;

/**
 * @author Grigoriy Zemlyanskiy
 * @version 1.0
 * interface PhoneRepo для работы с таблицей phone
 */
public interface PhoneRepo  extends JpaRepository<Phone, Long> {
    @Query(value
            = "select * "
            + "from public.phone  "
            + "where client_id = :id",
            nativeQuery = true)
    Optional<Set<Phone>> findAllByClientId(@Param("id")Long id);
}
