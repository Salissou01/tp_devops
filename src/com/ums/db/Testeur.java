package com.ums.db;

import com.ums.model.Classe;
import com.ums.model.Etudiant;
import com.ums.dao.ClasseDao;
import com.ums.dao.ClasseHbmDaoImpl;
import com.ums.dao.EtudiantDao;
import com.ums.dao.EtudiantHbmDaoImpl;
import com.ums.exceptions.DAOException;
import com.ums.dao.ConcreteFactory;


public class Testeur {


    public Classe creerClasse(String libelle) {
        ClasseDao classeDao = ConcreteFactory.getInstance().getClasseDao(ClasseHbmDaoImpl.class);
        Classe classe = null;
        try {
            classe = new Classe(libelle);
            classeDao.create(classe);
            System.out.println("Une nouvelle classe est ajoutée!");
        } catch (DAOException e) {
            System.out.println("Erreur lors de la création de la classe : " + e.getMessage());
        }
        return classe;
    }

    public Etudiant creerEtudiant(String nom, String prenom, Classe classe) {
        EtudiantDao etudiantDao = ConcreteFactory.getInstance().getEtudiantDao(EtudiantHbmDaoImpl.class);
        Etudiant etudiant = null;
        try {
            etudiant = new Etudiant(nom, prenom);
            etudiant.setClasse(classe);
            etudiantDao.create(etudiant);
            System.out.println("Un nouvel étudiant est ajouté!");
        } catch (DAOException e) {
            System.out.println("Erreur lors de la création de l'étudiant : " + e.getMessage());
        }
        return etudiant;
    }
}