//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.05.07 à 02:18:29 AM CEST 
//


package xml.integration2metier;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour JeuI2M complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="JeuI2M">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="joueur" type="{http://pds.m1.upec.fr/xml/integration2metier}JoueurI2M" maxOccurs="7" minOccurs="3"/>
 *         &lt;element name="partie" type="{http://pds.m1.upec.fr/xml/integration2metier}PartieI2M"/>
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
@XmlType(name = "JeuI2M", propOrder = {
    "joueur",
    "partie"
})
public class JeuI2M {

    @XmlElement(required = true)
    protected List<JoueurI2M> joueur;
    @XmlElement(required = true)
    protected PartieI2M partie;
    @XmlAttribute(name = "messageErreur")
    protected String messageErreur;

    /**
     * Gets the value of the joueur property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the joueur property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJoueur().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JoueurI2M }
     * 
     * 
     */
    public List<JoueurI2M> getJoueur() {
        if (joueur == null) {
            joueur = new ArrayList<JoueurI2M>();
        }
        return this.joueur;
    }

    /**
     * Obtient la valeur de la propriété partie.
     * 
     * @return
     *     possible object is
     *     {@link PartieI2M }
     *     
     */
    public PartieI2M getPartie() {
        return partie;
    }

    /**
     * Définit la valeur de la propriété partie.
     * 
     * @param value
     *     allowed object is
     *     {@link PartieI2M }
     *     
     */
    public void setPartie(PartieI2M value) {
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
