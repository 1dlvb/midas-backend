package ru.midas.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.midas.server.model.MidasUser;

@Repository
public interface MidasUserRepository extends JpaRepository<MidasUser, Long> {
    MidasUser findUserById(Long id);
}