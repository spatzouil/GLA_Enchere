package entity;

import entity.Article;
import entity.Enchere;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-28T13:12:16")
@StaticMetamodel(Utilisateur.class)
public class Utilisateur_ { 

    public static volatile ListAttribute<Utilisateur, Enchere> encheres;
    public static volatile SingularAttribute<Utilisateur, String> mdp;
    public static volatile SingularAttribute<Utilisateur, String> adresse;
    public static volatile SingularAttribute<Utilisateur, String> numeroBanquaire;
    public static volatile SingularAttribute<Utilisateur, Long> id;
    public static volatile SingularAttribute<Utilisateur, String> pseudo;
    public static volatile SingularAttribute<Utilisateur, String> nom;
    public static volatile SingularAttribute<Utilisateur, String> prenom;
    public static volatile ListAttribute<Utilisateur, Article> articles;

}