package entity;

import entity.Article;
import entity.Utilisateur;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-28T13:12:16")
@StaticMetamodel(Enchere.class)
public class Enchere_ { 

    public static volatile SingularAttribute<Enchere, Utilisateur> utilisateur;
    public static volatile SingularAttribute<Enchere, Double> montant;
    public static volatile SingularAttribute<Enchere, Long> id;
    public static volatile SingularAttribute<Enchere, Article> article;

}