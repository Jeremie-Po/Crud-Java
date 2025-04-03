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

    public AnnonceEntity addAnnonce(AnnonceEntity annonceEntity) {
        // Vous pouvez ajouter des validations ou des logiques métier ici avant d'ajouter l'annonce
        // Par exemple, vous pourriez vérifier que tous les champs obligatoires sont renseignés

        // Voici l'ajout d'annonce à la base de données en utilisant le repository avec la méthode save :
        return annonceRepository.save(annonceEntity);
    }

}
