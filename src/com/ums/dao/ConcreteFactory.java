package com.ums.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConcreteFactory implements AbstractFactory {
    private static ConcreteFactory instance = null;
    private SessionFactory sessionFactory;

    private ConcreteFactory() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static ConcreteFactory getInstance() {
        if (instance == null) {
            instance = new ConcreteFactory();
        }
        return instance;
    }

    @Override
    public EtudiantDao getEtudiantDao(Class<? extends EtudiantDao> daoClass) {
        if (daoClass == EtudiantHbmDaoImpl.class) {
            return new EtudiantHbmDaoImpl(sessionFactory);
        } else {
            throw new IllegalArgumentException("DAO class not supported: " + daoClass.getName());
        }
    }

    @Override
    public ClasseDao getClasseDao(Class<? extends ClasseDao> daoClass) {
        if (daoClass == ClasseHbmDaoImpl.class) {
            return new ClasseHbmDaoImpl(sessionFactory);
        } else {
            throw new IllegalArgumentException("DAO class not supported: " + daoClass.getName());
        }
    }
}