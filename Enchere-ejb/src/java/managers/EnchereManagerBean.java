/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Article;
import entity.Enchere;
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
public class EnchereManagerBean {

    @PersistenceContext(unitName = "Enchere-ejbPU")
    private EntityManager em;

    public void addEnchere(Enchere e) {
        em.persist(e);
    }
    
    public void deleteEnchere(Enchere e){
        em.remove(e);
    }
    
    public void deleteEnchereById(Long id){
        deleteEnchere(findById(id));
    }
        
     public List<Enchere> findAll(){
        return em.createNamedQuery("Enchere.findAll", Enchere.class)
                .getResultList();
    }
    
    
    public Enchere findById(Long id){
        return em.createNamedQuery("Enchere.findById", Enchere.class)
                .setParameter("i", id)
                .getSingleResult();
    }
    
    public List<Enchere> findByIdToken(){
        return em.createNamedQuery("Enchere.findByIdToken", Enchere.class)
        .setParameter("i", Token.getInstance().getToken().getId())
        .getResultList();
    }
        
}