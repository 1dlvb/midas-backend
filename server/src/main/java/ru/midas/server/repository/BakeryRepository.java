package ru.midas.server.repository;

import lombok.NonNull;
import ru.midas.server.model.Bakery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BakeryRepository extends JpaRepository<Bakery, Long> {
    Bakery findBakeryById(Long id);
}
