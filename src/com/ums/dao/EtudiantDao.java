package com.ums.dao;

import java.util.List;

import com.ums.exceptions.DAOException;
import com.ums.model.Etudiant;

public interface EtudiantDao {
    void create(Etudiant etudiant) throws DAOException;
    Etudiant read(int id) throws DAOException;
    List<Etudiant> list() throws DAOException;
    void update(Etudiant etudiant) throws DAOException;
    void delete(int id) throws DAOException;
}