/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package articles;

import entity.Article;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import managers.ArticleManagerBean;
//import managers.ArticleManagerBeanFactice;
import managers.UtilisateurManagerBean;


@Named(value = "articleAjoutBean")
@RequestScoped
public class ArticleAjoutBean {
    
    @Inject
    //ArticleManagerBeanFactice amb;
    ArticleManagerBean amb;
    
    @Inject
    //UtilisateurManagerBeanFactice umb;
    UtilisateurManagerBean umb;
    
    private String nom;
    private String description;
    private String categorie;
    private double prix;
    private Date dateFin;
    
    public String ajouterArticle(){
        Article a = new Article(nom, description, categorie, prix, dateFin);
        a.setUtilisateur(umb.getToken());
        amb.addArticle(a);
        return "articlesPerso";
    }
    
    public String retirerArticle(String id){
        //amb.addArticle(a);
        return "articlesPerso";
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
    
    public List<Article> findAllArticles(){
        return amb.findAll();
    }
                
    public List<Article> findArticlesByIdToken(){
        return amb.findByIdToken();
    }
       
    
}
