package com.immo.demo.mappers;

import com.immo.demo.dto.AnnonceDTO;
import com.immo.demo.entities.AnnonceEntity;

import java.util.List;
import java.util.stream.Collectors;


public class AnnonceMapper {

    public static AnnonceDTO convertToDTO(AnnonceEntity annonceEntity) {
        AnnonceDTO annonceDTO = new AnnonceDTO();
        annonceDTO.setId(annonceEntity.getId());
        annonceDTO.setTitre(annonceEntity.getTitre());
        annonceDTO.setDescription(annonceEntity.getDescription());
        annonceDTO.setPrix(annonceEntity.getPrix());
        annonceDTO.setEmplacement(annonceEntity.getEmplacement());
        annonceDTO.setDateCreation(annonceEntity.getDateCreation());
        annonceDTO.setAgenceId(annonceEntity.getAgence().getId());
        return annonceDTO;
    }

    public static List<AnnonceDTO> convertToDTOList(List<AnnonceEntity> annonceEntities) {
        return annonceEntities.stream()
                .map(AnnonceMapper::convertToDTO)
                .collect(Collectors.toList());
    }
}
