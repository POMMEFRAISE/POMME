//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.05.08 à 08:11:14 PM CEST 
//


package xml.integration2metier;

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
 *         &lt;element name="joueurs" type="{http://pds.m1.upec.fr/xml/integration2metier}ListeJoueursI2M"/>
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
    "joueurs",
    "partie"
})
public class JeuI2M {

    @XmlElement(required = true)
    protected ListeJoueursI2M joueurs;
    @XmlElement(required = true)
    protected PartieI2M partie;
    @XmlAttribute(name = "messageErreur")
    protected String messageErreur;

    /**
     * Obtient la valeur de la propriété joueurs.
     * 
     * @return
     *     possible object is
     *     {@link ListeJoueursI2M }
     *     
     */
    public ListeJoueursI2M getJoueurs() {
        return joueurs;
    }

    /**
     * Définit la valeur de la propriété joueurs.
     * 
     * @param value
     *     allowed object is
     *     {@link ListeJoueursI2M }
     *     
     */
    public void setJoueurs(ListeJoueursI2M value) {
        this.joueurs = value;
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
