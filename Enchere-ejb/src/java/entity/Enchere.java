/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author baudson3u
 */
@Entity
@Table(name = "ENCHERES")
@NamedQueries({
    @NamedQuery(name = "Enchere.findAll", query = "select e from Enchere e"),
    @NamedQuery(name = "Enchere.findById", query = "select e from Enchere e where e.id = :i"),
    @NamedQuery(name = "Enchere.findByIdToken", query = "select e from Enchere e where e.utilisateur.id = :i")

})
public class Enchere implements Serializable{
        
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "MONTANT")
    private double montant;
    
    @OneToOne
    private Article article;
    
    @OneToOne
    private Utilisateur utilisateur;

    public Enchere() {
    }

    public Enchere(double montant) {
        this.montant = montant;
    }
    
    public Enchere(double montant, Article a, Utilisateur u) {
        this.article = a;
        this.utilisateur = u;
        this.montant = montant;
    }
    
    public boolean equals(Enchere e){
        return(e.getId().equals(this.id));
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
    
    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
    

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    } 
   
    
    
}
