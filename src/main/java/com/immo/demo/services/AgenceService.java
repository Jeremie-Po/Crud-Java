package com.immo.demo.services;

import com.immo.demo.entities.AgenceEntity;
import com.immo.demo.repositories.AgenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

}
