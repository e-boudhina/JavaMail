/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Métier;

import java.util.Date;

/**
 *
 * @author e-boudhina
 */
public class SessionForm {
    
    private Date date_Debut;
    private Date date_Fin;
    private Date date_LimitInscription;
    private Integer capacite;
    private String type;
    private String lieu;
    private String adresse;
    private String cible;
    private Float prix;
    private String description;
    private String sujet;
    private String programme;

    
    public SessionForm(){
        
    }
    
    public SessionForm(Date date_Debut, Date date_Fin, Date date_LimitInscription, Integer capacite, String type, String lieu, String adresse, String cible, Float prix, String description, String sujet, String programme) {
        this.date_Debut = date_Debut;
        this.date_Fin = date_Fin;
        this.date_LimitInscription = date_LimitInscription;
        this.capacite = capacite;
        this.type = type;
        this.lieu = lieu;
        this.adresse = adresse;
        this.cible = cible;
        this.prix = prix;
        this.description = description;
        this.sujet = sujet;
        this.programme = programme;
    }
    
    

    public void setDate_Debut(Date date_Debut) {
        this.date_Debut = date_Debut;
    }

    public void setDate_Fin(Date date_Fin) {
        this.date_Fin = date_Fin;
    }

    public void setDate_LimitInscription(Date date_LimitInscription) {
        this.date_LimitInscription = date_LimitInscription;
    }

    public void setCapacite(Integer capacite) {
        this.capacite = capacite;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setCible(String cible) {
        this.cible = cible;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public Date getDate_Debut() {
        return date_Debut;
    }

    public Date getDate_Fin() {
        return date_Fin;
    }

    public Date getDate_LimitInscription() {
        return date_LimitInscription;
    }

    public Integer getCapacite() {
        return capacite;
    }

    public String getType() {
        return type;
    }

    public String getLieu() {
        return lieu;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getCible() {
        return cible;
    }

    public Float getPrix() {
        return prix;
    }

    public String getDescription() {
        return description;
    }

    public String getSujet() {
        return sujet;
    }

    public String getProgramme() {
        return programme;
    }

    @Override
    public String toString() {
        return "Session de formation de type \""+type+"\" Commence le \"" + date_Debut + "\" est terminera le \"" + date_Fin + " . Cette formation aura lieu au \""+ lieu+"\" plus précisément au \"" + adresse + "\" . Le sujet de cette formation est \"" + sujet +"\" est son prix est fixé à \"" + prix + "\" DT . Le nombre de place est limité à \"" + capacite + "\" ,donc faites vite est réserver votre place avant le \"" + date_LimitInscription +"\" . Cette formation est distiné à \"" + cible + "\" .";
    }
    
    
    
    
    
}
