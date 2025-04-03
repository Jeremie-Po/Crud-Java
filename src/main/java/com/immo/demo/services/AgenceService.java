package com.immo.demo.services;

import com.immo.demo.entities.AgenceEntity;
import com.immo.demo.repositories.AgenceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service()
public class AgenceService {
    private final AgenceRepository agenceRepository;

    @Autowired
    public AgenceService(AgenceRepository agenceRepository) {
        this.agenceRepository = agenceRepository;
    }

    public Page<AgenceEntity> getAllAgences(Pageable pageable) {
        return agenceRepository.findAll(pageable);
    }

    public AgenceEntity findOneById(Long id) {
        return agenceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("L'agence ayant l'id " + id + " n'existe pas!"));

    }

    public AgenceEntity addAgence(AgenceEntity agenceEntity) {
        return agenceRepository.save(agenceEntity);
    }

    public ResponseEntity<Object> deleteAgence(Long id) {
        AgenceEntity agence = this.findOneById(id);
        agenceRepository.delete(agence);
        ConfirmationMessage message = new ConfirmationMessage("L'agence " + agence.getNom() + " a bien été supprimée", HttpStatus.OK);

        return new ResponseEntity<>(message, HttpStatus.OK);

    }

}
