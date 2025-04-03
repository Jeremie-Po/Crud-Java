package com.immo.demo.controllers;

import com.immo.demo.entities.AnnonceEntity;
import com.immo.demo.services.AnnonceService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnnonceController {

    private final AnnonceService annonceService;

    public AnnonceController(AnnonceService annonceService) {
        this.annonceService = annonceService;
    }

    @GetMapping("/annonces/liste")
    public Page<AnnonceEntity> list(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "2") int size,
                                    @RequestParam(defaultValue = "id") String sortBy) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
//        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, sortBy));


        Page<AnnonceEntity> annonces = this.annonceService.getAllAnnonces(pageable);

        return annonces;
    }

    @GetMapping("/annonces/find/{id}")
    public AnnonceEntity find(@PathVariable Long id) {
        AnnonceEntity annonce = this.annonceService.findOneById(id);
        return annonce;
    }

//    @ExceptionHandler(EntityNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public String handleEntityNotFoundException(EntityNotFoundException ex) {
//        return ex.getMessage();
//    }

    @PostMapping("/annonces/create")
    @ResponseStatus(HttpStatus.CREATED)
    public AnnonceEntity add(@RequestBody AnnonceEntity annonceEntity) {
        // Ajouter l'annonce à la base de données en utilisant le service
        return annonceService.addAnnonce(annonceEntity);
    }

    @DeleteMapping("/annonces/delete/{id}")
    public Object delete(@PathVariable(name = "id") Long id) {
        return annonceService.deleteAnnonce(id);
    }
}
