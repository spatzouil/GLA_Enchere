/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere;

import entity.Article;
import entity.Enchere;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import managers.ArticleManagerBean;
import managers.EnchereManagerBean;
import managers.UtilisateurManagerBean;

@Named(value = "enchereAjoutBean")
@RequestScoped
public class EnchereAjoutBean {
    
    @Inject
    EnchereManagerBean emb;
    
    @Inject
    UtilisateurManagerBean umb;
    
    @Inject
    ArticleManagerBean amb;
    
    private double montant;
    
    public String enchereAjouter(){
        return "enchereAjouter";
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
    
    public String nouvelleEnchere(){
        Enchere e = new Enchere(montant);
        e.setUtilisateur(umb.getToken());
        emb.addEnchere(e);
        return "encheresPerso";
    }
    
    
    
}
