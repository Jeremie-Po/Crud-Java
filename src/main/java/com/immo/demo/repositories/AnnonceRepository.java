package com.immo.demo.repositories;

import com.immo.demo.entities.AnnonceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnonceRepository extends JpaRepository<AnnonceEntity, Long> {
    // Méthodes supplémentaires si nécessaire (que nous n'utilisons pas pour l'instant)
}
