/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Utilisateur;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import token.Token;


@Stateless
public class UtilisateurManagerBean {
    
    @PersistenceContext(unitName = "Enchere-ejbPU")
    private EntityManager em;

    public void addUtilisateur(Utilisateur user) {
        em.persist(user);
    }
    
    public boolean login(String pseudo, String password){
        List<Utilisateur> results = em.createNamedQuery("Utilisateur.findByPseudo", Utilisateur.class)
                .setParameter("p", pseudo)
                .getResultList();
        
        if(results.size() == 1){
            if (results.get(0).getMdp().equals(password)){
                setToken(results.get(0));
                return true;
            }
        }
        return false;
    }
    
    public String getTokenPseudo(){
        if(Token.getInstance().getToken().getPseudo() != null){
            return Token.getInstance().getToken().getPseudo();
        }
        return "coucou";
    }
    
    public Long getTokenId(){
        return Token.getInstance().getToken().getId();
    }
    
    public Utilisateur getToken(){
        return Token.getInstance().getToken();
    }
    
    public void setToken(Utilisateur u){
        Token.getInstance().connection(u);
    }
    
    public void unsetToken(){
        Token.getInstance().deconnection();
    }
    
}
