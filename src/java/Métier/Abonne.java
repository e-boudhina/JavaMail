/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Métier;

/**
 *
 * @author e-boudhina
 */
public class Abonne {
    
    private String nom;
    private String prenom;
    private String adresse;
    private Integer tel;
    private String email;

    public Abonne(){
        
    }
    
    public Abonne(String nom, String prenom, String adresse, Integer tel, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.tel = tel;
        this.email = email;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public Integer getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    
    
    
    
    
}
