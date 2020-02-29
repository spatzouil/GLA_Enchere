package entity;

import entity.Enchere;
import entity.Utilisateur;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-28T13:12:16")
@StaticMetamodel(Article.class)
public class Article_ { 

    public static volatile SingularAttribute<Article, String> categorie;
    public static volatile ListAttribute<Article, Enchere> encheres;
    public static volatile SingularAttribute<Article, Double> prix;
    public static volatile SingularAttribute<Article, Utilisateur> utilisateur;
    public static volatile SingularAttribute<Article, String> description;
    public static volatile SingularAttribute<Article, Long> id;
    public static volatile SingularAttribute<Article, Date> dateFin;
    public static volatile SingularAttribute<Article, String> nom;

}