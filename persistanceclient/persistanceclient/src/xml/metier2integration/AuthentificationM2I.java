//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2016.05.05 � 09:31:00 PM CEST 
//


package xml.metier2integration;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour AuthentificationM2I complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="AuthentificationM2I">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="loginAuthentification" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="mdpAuthentification" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="messageErreur" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuthentificationM2I")
public class AuthentificationM2I {

    @XmlAttribute(name = "loginAuthentification")
    protected String loginAuthentification;
    @XmlAttribute(name = "mdpAuthentification")
    protected String mdpAuthentification;
    @XmlAttribute(name = "messageErreur")
    protected String messageErreur;

    /**
     * Obtient la valeur de la propri�t� loginAuthentification.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginAuthentification() {
        return loginAuthentification;
    }

    /**
     * D�finit la valeur de la propri�t� loginAuthentification.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginAuthentification(String value) {
        this.loginAuthentification = value;
    }

    /**
     * Obtient la valeur de la propri�t� mdpAuthentification.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMdpAuthentification() {
        return mdpAuthentification;
    }

    /**
     * D�finit la valeur de la propri�t� mdpAuthentification.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMdpAuthentification(String value) {
        this.mdpAuthentification = value;
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
