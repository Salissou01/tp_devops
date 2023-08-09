package com.ums.db;

import com.ums.model.Classe;
import com.ums.model.Etudiant;

public class UMSApplication {
    private static Testeur testeur = new Testeur();

    public static void main(String[] args) {
        testerOneToMany();
    }

    public static void testerOneToMany() {
        Classe classe = testeur.creerClasse("INGC-123");
        Classe classe1 = testeur.creerClasse("ISI-123");
        Etudiant etudiant = testeur.creerEtudiant("YOSSEGUM", "Ivan", classe);
        Etudiant etudiant1 = testeur.creerEtudiant("Issoufou", "Salissou", classe1);
        Etudiant etudiant2 = testeur.creerEtudiant("Issoufou", "Mahamane", classe1);
        etudiant.setClasse(classe);
        etudiant1.setClasse(classe1);
        etudiant2.setClasse(classe1);
        System.out.println("Main program : " + etudiant + " added.");
        System.out.println("Main program : " + etudiant1 + " added.");
    }
}