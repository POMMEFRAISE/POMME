//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2016.05.05 � 04:24:02 PM CEST 
//


package xml.metier2integration;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour JoueurM2I complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
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
     * Obtient la valeur de la propri�t� nomJoueur.
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
     * D�finit la valeur de la propri�t� nomJoueur.
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
     * Obtient la valeur de la propri�t� prenomJoueur.
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
     * D�finit la valeur de la propri�t� prenomJoueur.
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
     * Obtient la valeur de la propri�t� loginJoueur.
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
     * D�finit la valeur de la propri�t� loginJoueur.
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
