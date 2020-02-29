/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Article;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import token.Token;

/**
 *
 * @author clem
 */
@Stateless
public class ArticleManagerBean {

    @PersistenceContext(unitName = "Enchere-ejbPU")
    private EntityManager em;

    public void addArticle(Article a) {
        em.persist(a);
    }
    
    public void deleteArticle(Article a){
        em.remove(em.merge(a));
    }
    
    public void deleteArticleById(Long id){
        Article a = findById(id);
        deleteArticle(a);
    }
    
    public List<Article> findAll(){
        return em.createNamedQuery("Article.findAll", Article.class)
                .getResultList();
    }
    
    public List<Article> findByCategorie(String categorie){
        return em.createNamedQuery("Article.findByCategorie", Article.class)
                .setParameter("c", categorie)
                .getResultList();
    }
    
    public List<Article> findByNom(String nom){
        return em.createNamedQuery("Article.findByNom", Article.class)
                .setParameter("n", nom)
                .getResultList();
    }
    
    public Article findById(Long id){
        return em.createNamedQuery("Article.findById", Article.class)
                .setParameter("i", id)
                .getSingleResult();
    }
    
    public List<Article> findByIdToken(){
        return em.createNamedQuery("Article.findByIdToken", Article.class)
        .setParameter("i", Token.getInstance().getToken().getId())
        .getResultList();
    }
    
}
