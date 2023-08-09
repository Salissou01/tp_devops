package com.ums.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ums.exceptions.DAOException;
import com.ums.model.Classe;

public class ClasseHbmDaoImpl implements ClasseDao {
    private SessionFactory sessionFactory;

    public ClasseHbmDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Classe classe) throws DAOException {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(classe);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DAOException("Erreur lors de la création de la classe : " + e.getMessage());
        }
    }

    @Override
    public Classe read(int id) throws DAOException {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Classe.class, id);
        } catch (Exception e) {
            throw new DAOException("Erreur lors de la récupération de la classe : " + e.getMessage());
        }
    }

    @Override
    public List<Classe> list() throws DAOException {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Classe", Classe.class).list();
        } catch (Exception e) {
            throw new DAOException("Erreur lors de la récupération de la liste des classes : " + e.getMessage());
        }
    }

    @Override
    public void update(Classe classe) throws DAOException {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(classe);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DAOException("Erreur lors de la mise à jour de la classe : " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) throws DAOException {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Classe classe = session.get(Classe.class, id);
            if (classe != null) {
                session.delete(classe);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DAOException("Erreur lors de la suppression de la classe : " + e.getMessage());
        }
    }
}