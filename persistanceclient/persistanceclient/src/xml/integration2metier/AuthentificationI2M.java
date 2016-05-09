//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2016.05.09 � 12:03:57 AM CEST 
//


package xml.integration2metier;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour AuthentificationI2M complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="AuthentificationI2M">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="joueur" type="{http://pds.m1.upec.fr/xml/integration2metier}JoueurI2M"/>
 *       &lt;/sequence>
 *       &lt;attribute name="messageErreur" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuthentificationI2M", propOrder = {
    "joueur"
})
public class AuthentificationI2M {

    @XmlElement(required = true)
    protected JoueurI2M joueur;
    @XmlAttribute(name = "messageErreur")
    protected String messageErreur;

    /**
     * Obtient la valeur de la propri�t� joueur.
     * 
     * @return
     *     possible object is
     *     {@link JoueurI2M }
     *     
     */
    public JoueurI2M getJoueur() {
        return joueur;
    }

    /**
     * D�finit la valeur de la propri�t� joueur.
     * 
     * @param value
     *     allowed object is
     *     {@link JoueurI2M }
     *     
     */
    public void setJoueur(JoueurI2M value) {
        this.joueur = value;
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
