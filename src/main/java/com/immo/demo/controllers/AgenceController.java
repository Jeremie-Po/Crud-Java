package com.immo.demo.controllers;

import com.immo.demo.entities.AgenceEntity;
import com.immo.demo.services.AgenceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class AgenceController {

    private final AgenceService agenceService;

    public AgenceController(AgenceService agenceService) {

        this.agenceService = agenceService;
    }

    @GetMapping("/agences/liste")
    public Page<AgenceEntity> list(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "2") int size,
                                   @RequestParam(defaultValue = "id") String sortBy) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

        Page<AgenceEntity> agences = this.agenceService.getAllAgences(pageable);

        return agences;
    }

    @GetMapping("/agences/find/{id}")
    public AgenceEntity find(@PathVariable(name = "id") Long id) {
        AgenceEntity agence = this.agenceService.findOneById(id);
        return agence;
    }

    @PostMapping("/agences/create")
    @ResponseStatus(HttpStatus.CREATED)
    public AgenceEntity create(@RequestBody AgenceEntity agenceEntity) {

        return agenceService.addAgence(agenceEntity);
    }

    @DeleteMapping("/agences/delete/{id}")
    public Object delete(@PathVariable(name = "id") Long id) {

        return agenceService.deleteAgence(id);
    }

    @PatchMapping("/agences/update/{id}")
    public AgenceEntity update(@PathVariable(name = "id") Long id, @RequestBody AgenceEntity partialAgence) {

        return agenceService.updateAgence(id, partialAgence);
    }
}
