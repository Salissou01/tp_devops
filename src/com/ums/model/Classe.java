package com.ums.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;



@Entity(name = "t_classe")
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_classe")
    private int id;
    private String libelle;
    @OneToMany(mappedBy = "classe")
    protected List<Etudiant> etudiants = new ArrayList<>();

    public Classe() {}

    public Classe(String libelle) {
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

 
}