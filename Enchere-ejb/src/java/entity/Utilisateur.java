/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "UTILISATEURS")
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "select u from Utilisateur u"),
    @NamedQuery(name = "Utilisateur.findByPseudo", query = "select u from Utilisateur u where u.pseudo = :p")
})
public class Utilisateur implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "PSEUDO")
    private String pseudo;
    
    @Column(name = "MDP")
    private String mdp;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "PRENOM")
    private String prenom;

    @Column(name = "ADRESSE")
    private String adresse;

    @Column(name = "NUMEROBANQUAIRE")
    private String numeroBanquaire;
    
    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private List<Enchere> encheres;
    
    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private List<Article> articles;
    
    
    public Utilisateur(){
        
    }
    
    public Utilisateur(String nom, String prenom, String adresse, String numeroBanquaire, String pseudo, String mdp){
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.numeroBanquaire = numeroBanquaire;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
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
    
    public List<Enchere> getEncheres() {
        return encheres;
    }

    public void setEncheres(List<Enchere> encheres) {
        this.encheres = encheres;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
    
    
    
}
