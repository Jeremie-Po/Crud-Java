package com.immo.demo.dto;

import java.time.LocalDateTime;

public class AnnonceDTO {

    private Long id;
    private String titre;
    private String description;
    private Double prix;
    private String emplacement;
    private LocalDateTime dateCreation;
    private Long agenceId; // Pour référencer l'ID de l'agence plutôt que l'entité elle-même

    public AnnonceDTO() {
        // Constructeur vide nécessaire pour certaines opérations
    }

    public AnnonceDTO(Long id, String titre, String description, Double prix, String emplacement,
                      LocalDateTime dateCreation, Long agenceId) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.prix = prix;
        this.emplacement = emplacement;
        this.dateCreation = dateCreation;
        this.agenceId = agenceId;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Long getAgenceId() {
        return agenceId;
    }

    public void setAgenceId(Long agenceId) {
        this.agenceId = agenceId;
    }
}

