package com.immo.demo.repositories;

import com.immo.demo.entities.AgenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgenceRepository extends JpaRepository<AgenceEntity, Long> {
    // Méthodes supplémentaires si nécessaire (que nous n'utilisons pas pour l'instant)

}
