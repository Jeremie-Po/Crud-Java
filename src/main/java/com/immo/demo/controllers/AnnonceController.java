package com.immo.demo.controllers;

import com.immo.demo.entities.AnnonceEntity;
import com.immo.demo.services.AnnonceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnnonceController {

    private final AnnonceService annonceService;

    public AnnonceController(AnnonceService annonceService) {
        this.annonceService = annonceService;
    }

    @GetMapping("/annonces/liste")
    public List<AnnonceEntity> list() {
        List<AnnonceEntity> annonces = this.annonceService.getAllAnnonces();
        return annonces;
    }
}
