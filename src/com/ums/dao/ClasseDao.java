package com.ums.dao;

import java.util.List;

import com.ums.exceptions.DAOException;
import com.ums.model.Classe;

public interface ClasseDao {
    void create(Classe classe) throws DAOException;
    Classe read(int id) throws DAOException;
    List<Classe> list() throws DAOException;
    void update(Classe classe) throws DAOException;
    void delete(int id) throws DAOException;
}