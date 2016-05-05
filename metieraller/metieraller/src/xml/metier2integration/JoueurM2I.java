//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.05.05 à 04:24:02 PM CEST 
//


package xml.metier2integration;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour JoueurM2I complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="JoueurM2I">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="nomJoueur" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="prenomJoueur" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="loginJoueur" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JoueurM2I")
public class JoueurM2I {

    @XmlAttribute(name = "nomJoueur")
    protected String nomJoueur;
    @XmlAttribute(name = "prenomJoueur")
    protected String prenomJoueur;
    @XmlAttribute(name = "loginJoueur")
    protected String loginJoueur;

    /**
     * Obtient la valeur de la propriété nomJoueur.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomJoueur() {
        return nomJoueur;
    }

    /**
     * Définit la valeur de la propriété nomJoueur.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomJoueur(String value) {
        this.nomJoueur = value;
    }

    /**
     * Obtient la valeur de la propriété prenomJoueur.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrenomJoueur() {
        return prenomJoueur;
    }

    /**
     * Définit la valeur de la propriété prenomJoueur.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrenomJoueur(String value) {
        this.prenomJoueur = value;
    }

    /**
     * Obtient la valeur de la propriété loginJoueur.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginJoueur() {
        return loginJoueur;
    }

    /**
     * Définit la valeur de la propriété loginJoueur.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginJoueur(String value) {
        this.loginJoueur = value;
    }

}
