//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2016.05.08 � 08:10:32 PM CEST 
//


package xml.metier2integration;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour CreationPartieM2I complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="CreationPartieM2I">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="nomPartie" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="nbJoueurPartie" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="messageErreur" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreationPartieM2I")
public class CreationPartieM2I {

    @XmlAttribute(name = "nomPartie")
    protected String nomPartie;
    @XmlAttribute(name = "nbJoueurPartie")
    protected Integer nbJoueurPartie;
    @XmlAttribute(name = "messageErreur")
    protected String messageErreur;

    /**
     * Obtient la valeur de la propri�t� nomPartie.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomPartie() {
        return nomPartie;
    }

    /**
     * D�finit la valeur de la propri�t� nomPartie.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomPartie(String value) {
        this.nomPartie = value;
    }

    /**
     * Obtient la valeur de la propri�t� nbJoueurPartie.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNbJoueurPartie() {
        return nbJoueurPartie;
    }

    /**
     * D�finit la valeur de la propri�t� nbJoueurPartie.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNbJoueurPartie(Integer value) {
        this.nbJoueurPartie = value;
    }

    /**
     * Obtient la valeur de la propri�t� messageErreur.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageErreur() {
        return messageErreur;
    }

    /**
     * D�finit la valeur de la propri�t� messageErreur.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageErreur(String value) {
        this.messageErreur = value;
    }

}
