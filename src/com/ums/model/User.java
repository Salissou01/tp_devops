package com.ums.model;



import java.io.Serializable;

import jakarta.persistence.*;



@Entity
@Table(name="t_users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int identifiant;
    
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String login;
    private String password;
    private String role;

    public User() {
        
    }

    public User(String nom, String prenom, String email, String telephone, String login, String password, Role role) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.login = login;
        this.password = password;
        this.role = role.name();
    }

    public String getNom() {
        return nom;
    }

    

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }


    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getLogin() {
        return login;
    }


    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

   

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

   

    public void setRole(String role) {
        this.role = role;
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
       
        if (!(obj instanceof User)) return false;
       
        if (this.identifiant == ((User)obj).getIdentifiant())
            return true;
       
        return false;            
    }
}
