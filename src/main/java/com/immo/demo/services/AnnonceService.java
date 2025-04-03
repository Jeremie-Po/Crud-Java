package com.immo.demo.services;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.immo.demo.dto.AnnonceDTO;
import com.immo.demo.mappers.AnnonceMapper;
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

import com.immo.demo.entities.AnnonceEntity;
import com.immo.demo.repositories.AnnonceRepository;


@Service()
public class AnnonceService {
    private final AnnonceRepository annonceRepository;

    @Autowired
    public AnnonceService(AnnonceRepository annonceRepository) {
        this.annonceRepository = annonceRepository;
    }

//    public Page<AnnonceEntity> getAllAnnonces(Pageable pageable) {
//        return annonceRepository.findAll(pageable);
//    }

    public Page<AnnonceDTO> getAllAnnonces(Pageable pageable) {
        Page<AnnonceEntity> annoncePage = annonceRepository.findAll(pageable);
//        List<AnnonceEntity> annonceEntities = annoncePage.getContent();
//        return AnnonceMapper.convertToDTOList(annonceEntities);
        return annoncePage.map(AnnonceMapper::convertToDTO);
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

    @Transactional
    public ResponseEntity<Object> deleteAnnonce(Long id) {
        AnnonceEntity annonce = this.findOneById(id);
        annonceRepository.delete(annonce);
        ConfirmationMessage message = new ConfirmationMessage("L'annonce a bien été supprimée", HttpStatus.OK);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    public AnnonceEntity updateAnnonce(Long id, AnnonceEntity partialAnnonce) {
        AnnonceEntity existingAnnonce = this.findOneById(id);
        // Copier les propriétés non nulles de partialAnnonce vers existingAnnonce
        BeanUtils.copyProperties(partialAnnonce, existingAnnonce, getNullPropertyNames(partialAnnonce));

        return annonceRepository.save(existingAnnonce);
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
