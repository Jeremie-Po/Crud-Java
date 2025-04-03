package com.immo.demo.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "agences_immobilieres")
public class AgenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String adresse;

    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL)
    private List<AnnonceEntity> annonces;

    public AgenceEntity() {
        // Constructeur vide nécessaire pour Hibernate
    }

    public AgenceEntity(String nom, String adresse, List<AnnonceEntity> annonces) {
        this.nom = nom;
        this.adresse = adresse;
        this.annonces = annonces;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<AnnonceEntity> getAnnonces() {
        return annonces;
    }

    public void setAnnonces(List<AnnonceEntity> annonces) {
        this.annonces = annonces;
    }
}

