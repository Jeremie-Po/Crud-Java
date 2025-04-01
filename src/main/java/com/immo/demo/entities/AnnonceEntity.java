package com.immo.demo.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "annonces_immobilieres")
public class AnnonceEntity {


    @Id
    @GeneratedValue
    private Long id;

    private String titre;

    private String description;

    private double prix;

    private String emplacement;

    @Column(name = "date_creation")
    private LocalDateTime dateCreation;

    public AnnonceEntity() {
        // Constructeur vide nécessaire pour Hibernate
    }

    public AnnonceEntity(String titre, String description, double prix, String emplacement, LocalDateTime dateCreation) {
        this.titre = titre;
        this.description = description;
        this.prix = prix;
        this.emplacement = emplacement;
        this.dateCreation = dateCreation;
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

    public double getPrix() {
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
}


