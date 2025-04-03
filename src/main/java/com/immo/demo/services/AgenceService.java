package com.immo.demo.services;

import com.immo.demo.entities.AgenceEntity;
import com.immo.demo.entities.AnnonceEntity;
import com.immo.demo.repositories.AgenceRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

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

    @Transactional
    public ResponseEntity<Object> deleteAgence(Long id) {
        AgenceEntity agence = this.findOneById(id);
        agenceRepository.delete(agence);
        ConfirmationMessage message = new ConfirmationMessage("L'agence " + agence.getNom() + " a bien été supprimée", HttpStatus.OK);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    public AgenceEntity updateAgence(Long id, AgenceEntity partialAgence) {
        AgenceEntity existingAgence = this.findOneById(id);

        // Copier les propriétés non nulles de partialAnnonce vers existingAnnonce
        BeanUtils.copyProperties(partialAgence, existingAgence, getNullPropertyNames(partialAgence));


        return agenceRepository.save(existingAgence);
    }

    private String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet<>();
        for (PropertyDescriptor pd : pds) {

            System.out.println("PDS => " + pd);

            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        return emptyNames.toArray(new String[0]);
    }

}
