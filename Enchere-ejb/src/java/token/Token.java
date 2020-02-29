/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package token;

import entity.Utilisateur;

/**
 *
 * @author clem
 */
public class Token {
    
    private Utilisateur token;
    
    private Token(){
        this.token = null;
    }
     
    private static Token INSTANCE = null;
 
    public static Token getInstance(){
        if (INSTANCE == null){
            INSTANCE = new Token(); 
        }
        return INSTANCE;
    }
    
    public void connection(Utilisateur u){
        this.token = u;
    }
    
    public Utilisateur getToken(){
        return this.token;
    }
    
    public void deconnection(){
        this.token = null;
    }
    
    
}
