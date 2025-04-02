package com.immo.demo.services;

import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.immo.demo.entities.AnnonceEntity;
import com.immo.demo.repositories.AnnonceRepository;


@Service()
public class AnnonceService {
    private final AnnonceRepository annonceRepository;

    @Autowired
    public AnnonceService(AnnonceRepository annonceRepository) {
        this.annonceRepository = annonceRepository;
    }

    public Page<AnnonceEntity> getAllAnnonces(Pageable pageable) {
        return annonceRepository.findAll(pageable);
    }

    public AnnonceEntity findOneById(Long id) {
        return annonceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("L'annonce ayant l'id " + id + " n'existe pas!"));
    }

}
