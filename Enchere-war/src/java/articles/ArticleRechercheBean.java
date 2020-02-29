/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package articles;

import entity.Article;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import managers.ArticleManagerBean;


@Named(value = "articleRechercheBean")
@RequestScoped
public class ArticleRechercheBean {
    
    @Inject
    ArticleManagerBean amb;
    
    private String nom;
    private String categorie;
    private Long id;
    
    public Long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    public String articles(){
        return "articles";
    }
    
    public String consulter(Long id){
        this.setId(id);
        return "article";
    }
    
    public String articleAjouter(){
        return "articleAjouter";
    }
    
    public String articlesPerso(){
        return "articlesPerso";
    }
    
    public String findByName(){
        return "articlesByName";
    }
    
    public String findByCategory(){
        return "articlesByCategory";
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
    
    public List<Article> findArticlesByNom(String nom){
        return amb.findByNom(nom);
    }
    
    public List<Article> findArticlesByCategorie(String categorie){
        return amb.findByCategorie(categorie);
    }
    
}
