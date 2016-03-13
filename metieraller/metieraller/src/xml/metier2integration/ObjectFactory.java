//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.02.28 à 03:23:46 PM CET 
//


package xml.metier2integration;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the xml.metier2integration package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: xml.metier2integration
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DemanderAuthentification }
     * 
     */
    public DemanderAuthentification createDemanderAuthentification() {
        return new DemanderAuthentification();
    }

    /**
     * Create an instance of {@link SeConnecter }
     * 
     */
    public SeConnecter createSeConnecter() {
        return new SeConnecter();
    }

    /**
     * Create an instance of {@link Authentification }
     * 
     */
    public Authentification createAuthentification() {
        return new Authentification();
    }

    /**
     * Create an instance of {@link De }
     * 
     */
    public De createDe() {
        return new De();
    }

    /**
     * Create an instance of {@link Joueur }
     * 
     */
    public Joueur createJoueur() {
        return new Joueur();
    }

    /**
     * Create an instance of {@link Partie }
     * 
     */
    public Partie createPartie() {
        return new Partie();
    }

}
