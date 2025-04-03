package com.immo.demo.entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import com.immo.demo.utilities.LocalDateTimeDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "annonces_immobilieres")
public class AnnonceEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    private String description;

    private Double prix;

    private String emplacement;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @Column(name = "date_creation")
    private LocalDateTime dateCreation;

    @ManyToOne
    @JsonIgnoreProperties("annonces")
    @JoinColumn(name = "agence_id")
    private AgenceEntity agence;

    public AnnonceEntity() {
        // Constructeur vide nécessaire pour Hibernate
    }

    public AnnonceEntity(String titre, String description, double prix, String emplacement, LocalDateTime dateCreation, AgenceEntity agence) {
        this.titre = titre;
        this.description = description;
        this.prix = prix;
        this.emplacement = emplacement;
        this.dateCreation = dateCreation;
        this.agence = agence;
    }

    // Getters et setters
    public Long getId() {

        return id;
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

    public void setPrix(double prix) {

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

    public AgenceEntity getAgence() {
        return agence;
    }

    public void setAgence(AgenceEntity agence) {
        this.agence = agence;
    }
}


