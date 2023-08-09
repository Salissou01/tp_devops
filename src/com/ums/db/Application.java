package com.ums.db;

import java.util.List;

import org.hibernate.Session;

import com.ums.dao.*;
import com.ums.db.dao.*;
import com.ums.model.*;
import java.util.*;
public class Application {

	public static void main(String[] args) throws UMSDBException {
		// TODO Auto-generated method stub
HibernateConnection hbm = HibernateConnection.getInstance();
Session session =hbm.getSession();
if(session.isOpen()) {
	System.out.println("Hibernate demarré avec succés");
	User user1= new User("Issoufou","Salissou","Issoufou365@gmail.com","1234567","iss.sa","poik",Role.ADMINISTRATEUR);
	IDao<User> dao=new HibernateUserDaoImpl();
	dao.create(user1);
	int id=2;
	User user=dao.read(id);
	if (user != null) {
		System.out.println("Nom: " + user.getNom());
		System.out.println("Prenom: " + user.getPrenom());
		System.out.println("Email: " + user.getEmail());
	} else {
		System.out.println("Aucun utilisateur trouvé avec l'identifiant " + id);
	}
	user.setPassword("newpassword");
    try {
        dao.update(user);
        System.out.println("Utilisateur mis à jour avec succès.");
    } catch (UMSDBException e) {
        System.out.println("Erreur lors de la mise à jour de l'utilisateur : " + e.getMessage());
    }
  //Liste des utilisateurs
    try {
        List<User> userList = dao.list();
        System.out.println("Liste des utilisateurs :");
        for (User user3 : userList) {
            
            System.out.println("Nom: " + user3.getNom());
    		System.out.println("Prenom: " + user3.getPrenom());
    		System.out.println("Email: " + user3.getEmail());
    		System.out.println("Password: " + user3.getPassword());
        }
    } catch (UMSDBException e) {
        System.out.println("Erreur lors de la récupération de la liste des utilisateurs : " + e.getMessage());
    }
 // Suppression d'un utilisateur
   /* try {
        dao.delete(id);
        System.out.println("Utilisateur supprimé avec succès.");
    } catch (UMSDBException e) {
        System.out.println("Erreur lors de la suppression de l'utilisateur : " + e.getMessage());
    }*/
	session.close();
} else {
	System.out.println("Hibernate non demarré avec succés");
	
}

	}

}
