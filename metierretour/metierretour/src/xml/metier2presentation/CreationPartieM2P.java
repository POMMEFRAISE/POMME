//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.05.06 à 10:28:05 PM CEST 
//


package xml.metier2presentation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour CreationPartieM2P complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="CreationPartieM2P">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="partie" type="{http://pds.m1.upec.fr/xml/metier2presentation}PartieM2P"/>
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
@XmlType(name = "CreationPartieM2P", propOrder = {
    "partie"
})
public class CreationPartieM2P {

    @XmlElement(required = true)
    protected PartieM2P partie;
    @XmlAttribute(name = "messageErreur")
    protected String messageErreur;

    /**
     * Obtient la valeur de la propriété partie.
     * 
     * @return
     *     possible object is
     *     {@link PartieM2P }
     *     
     */
    public PartieM2P getPartie() {
        return partie;
    }

    /**
     * Définit la valeur de la propriété partie.
     * 
     * @param value
     *     allowed object is
     *     {@link PartieM2P }
     *     
     */
    public void setPartie(PartieM2P value) {
        this.partie = value;
    }

    /**
     * Obtient la valeur de la propriété messageErreur.
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
     * Définit la valeur de la propriété messageErreur.
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
