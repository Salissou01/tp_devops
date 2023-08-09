package com.ums.dao;

public interface AbstractFactory {
    EtudiantDao getEtudiantDao(Class<? extends EtudiantDao> daoClass);
    ClasseDao getClasseDao(Class<? extends ClasseDao> daoClass);
}