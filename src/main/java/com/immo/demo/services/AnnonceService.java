package com.immo.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    public List<AnnonceEntity> getAllAnnonces() {
        return annonceRepository.findAll();
    }

}
