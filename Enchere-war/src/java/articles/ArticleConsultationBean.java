/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package articles;

import entity.Article;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import managers.ArticleManagerBean;
import managers.UtilisateurManagerBean;
//import managers.UtilisateurManagerBeanFactice;
//import managers.ArticleManagerBeanFactice;

@Named(value = "articleConsultationBean")
@RequestScoped
public class ArticleConsultationBean {
    
    @Inject
    //ArticleManagerBeanFactice amb;
    ArticleManagerBean amb;
    
    @Inject
    //UtilisateurManagerBeanFactice umb;
    UtilisateurManagerBean umb;
    
    private Article article;
    
    public String consulter(Long id){
        article = amb.findById(id);
        System.out.println("*************************************" + id + "INCONS" + "***************************************");
        return "article";
    }
    
    
    public Article getArticle(){
        return article;
    }
    
    public Long getId() {
        return article.getId();
    }

    public String getNom() {
        return article.getNom();
    }

    public void setNom(String nom) {
        article.setNom(nom);
    }
    
    public String getCategorie() {
        return article.getCategorie();
    }

    public void setCategorie(String categorie) {
        article.setCategorie(categorie);
    }

    public String getDescription() {
        return article.getDescription();
    }

    public void setDescription(String description) {
        article.setDescription(description);
    }

    public double getPrix() {
        return article.getPrix();
    }

    public void setPrix(double prix) {
        article.setPrix(prix);
    }

    public Date getDateFin() {
        return article.getDate();
    }

    public void setDateFin(Date dateFin) {
        article.setDate(dateFin);
    }
    
    public String deleteArticle(Long id){
        amb.deleteArticleById(id);        
        return "articlesPerso";
    }
    
}
