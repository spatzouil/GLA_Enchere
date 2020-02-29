/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author baudson3u
 */
@Entity
@Table(name = "ARTICLES")
@NamedQueries({
    @NamedQuery(name = "Article.findAll", query = "select a from Article a"),
    @NamedQuery(name = "Article.findById", query = "select a from Article a where a.id = :i"),
    @NamedQuery(name = "Article.findByIdToken", query = "select a from Article a where a.utilisateur.id = :i"),
    @NamedQuery(name = "Article.deleteById", query = "delete from Article a where a.id = :i"),
    @NamedQuery(name = "Article.findByNom", query = "select a from Article a where lower(a.nom) = lower(:n)"),
    @NamedQuery(name = "Article.findByCategorie", query = "select a from Article a where lower(a.categorie) like lower(:c)")
})
public class Article implements Serializable{
        
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "NOM")
    private String nom;
    
    @Column(name = "DESCRIPTION")
    private String description;
    
    @Column(name = "CATEGORIE")
    private String categorie;
    
    @Column(name = "PRIX")
    private double prix;
    
    @Column(name = "DATEFIN")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFin;
    
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<Enchere> encheres;
    
    @ManyToOne
    private Utilisateur utilisateur;

    public Article() {
        
    }
    
    
    public Article(String nom, String description, String categorie, double prix, Date dateFin) {
        this.nom = nom;
        this.description = description;
        this.categorie = categorie;
        this.prix = prix;
        this.dateFin = dateFin;
    }
    
    public Article(String nom, String description, double prix, Date dateFin) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.dateFin = dateFin;
    }
    
    public boolean equals(Article a){
        return(a.getId().equals(this.id));
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Date getDate() {
        return dateFin;
    }

    public void setDate(Date date) {
        this.dateFin = date;
    }
      
    public List<Enchere> getEncheres() {
        return encheres;
    }

    public void setEncheres(List<Enchere> encheres) {
        this.encheres = encheres;
    }

    
    
    
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    
       
    
    
}
