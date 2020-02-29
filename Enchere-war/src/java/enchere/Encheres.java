/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere;

import entity.Article;
import entity.Enchere;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import managers.EnchereManagerBean;
//import managers.EnchereManagerBeanFactice;


@Named(value = "encheres")
@RequestScoped
public class Encheres {
    
    @Inject
    //EnchereManagerBeanFactice emb;
    EnchereManagerBean emb;
    
    private Long idArticle;
    
    public String encheresPerso(){
        return "encheresPerso";
    }
    
    public String enchere(){
        return "enchere";
    }
    
    
    public List<Enchere> findById(){
        /*
        Long test = new Long(5);
        long test2 = 5;
        return emb.findById(test);
        */
        return emb.findAll();
    }
    
    public String deleteEnchere(Long id){
        emb.deleteEnchereById(id);        
        return "encheresPerso";
    }
    
    public List<Enchere> findArticlesByIdToken(){
        return emb.findByIdToken();
    }
    
}
