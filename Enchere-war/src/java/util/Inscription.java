/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.Utilisateur;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotEmpty;
import managers.UtilisateurManagerBean;
//import managers.UtilisateurManagerBeanFactice;

/**
 *
 * @author baudson3u
 */
@Named(value = "inscription")
@RequestScoped
public class Inscription {
    
    @Inject
    UtilisateurManagerBean umb;
    //UtilisateurManagerBeanFactice umb;
    
    @NotEmpty
    private String pseudo;
    
    @NotEmpty
    private String mdp;
    
    @NotEmpty
    private String nom;
   
    @NotEmpty
    private String prenom;
    
    @NotEmpty
    private String adresse;
    
    @NotEmpty
    private String numeroBanquaire;

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumeroBanquaire() {
        return numeroBanquaire;
    }

    public void setNumeroBanquaire(String numeroBanquaire) {
        this.numeroBanquaire = numeroBanquaire;
    }
    
    
    
    public String inscription(){
        return "inscription";
    }
    
    public String inscriptionOK(){
        boolean inscriptionValide = true;
        if(inscriptionValide){
            Utilisateur u = new Utilisateur(nom, prenom, adresse, numeroBanquaire, pseudo, mdp);
            umb.addUtilisateur(u);
            umb.setToken(u);
            return "accueil";
        }else{
            return "inscription";
        }
    }
    
    public String test(){
        Utilisateur u = new Utilisateur(nom, prenom, adresse, numeroBanquaire, pseudo, mdp);
        umb.addUtilisateur(u);
        return "umb.addUtilisateur(u)";
    }
    
}
