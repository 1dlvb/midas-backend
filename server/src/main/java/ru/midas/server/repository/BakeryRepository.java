package ru.midas.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.midas.server.model.Bakery;

public interface BskeryRepository extends JpaRepository<Bakery, Long> {
}
