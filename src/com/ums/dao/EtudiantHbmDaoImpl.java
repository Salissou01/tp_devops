package com.ums.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ums.exceptions.DAOException;
import com.ums.model.Etudiant;

public class EtudiantHbmDaoImpl implements EtudiantDao {
    private SessionFactory sessionFactory;

    public EtudiantHbmDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Etudiant etudiant) throws DAOException {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(etudiant);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DAOException("Erreur lors de la création de l'étudiant : " + e.getMessage());
        }
    }

    @Override
    public Etudiant read(int id) throws DAOException {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Etudiant.class, id);
        } catch (Exception e) {
            throw new DAOException("Erreur lors de la récupération de l'étudiant : " + e.getMessage());
        }
    }

    @Override
    public List<Etudiant> list() throws DAOException {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Etudiant", Etudiant.class).list();
        } catch (Exception e) {
            throw new DAOException("Erreur lors de la récupération de la liste des étudiants : " + e.getMessage());
        }
    }

    @Override
    public void update(Etudiant etudiant) throws DAOException {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(etudiant);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DAOException("Erreur lors de la mise à jour de l'étudiant : " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) throws DAOException {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Etudiant etudiant = session.get(Etudiant.class, id);
            if (etudiant != null) {
                session.delete(etudiant);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DAOException("Erreur lors de la suppression de l'étudiant : " + e.getMessage());
        }
    }
}