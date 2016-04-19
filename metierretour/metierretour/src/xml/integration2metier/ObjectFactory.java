//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.04.18 à 09:59:58 PM CEST 
//


package xml.integration2metier;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the xml.integration2metier package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: xml.integration2metier
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReponseSeConnecterI2M }
     * 
     */
    public ReponseSeConnecterI2M createReponseSeConnecterI2M() {
        return new ReponseSeConnecterI2M();
    }

    /**
     * Create an instance of {@link AuthentificationI2M }
     * 
     */
    public AuthentificationI2M createAuthentificationI2M() {
        return new AuthentificationI2M();
    }

    /**
     * Create an instance of {@link ReponseDemanderAuthentificationI2M }
     * 
     */
    public ReponseDemanderAuthentificationI2M createReponseDemanderAuthentificationI2M() {
        return new ReponseDemanderAuthentificationI2M();
    }

    /**
     * Create an instance of {@link JoueurI2M }
     * 
     */
    public JoueurI2M createJoueurI2M() {
        return new JoueurI2M();
    }

}
