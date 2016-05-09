//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.05.09 à 12:01:37 AM CEST 
//


package xml.presentation2metier;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour JeuP2M complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="JeuP2M">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="listeJoueurs" type="{http://pds.m1.upec.fr/xml/presentation2metier}ListeJoueursP2M"/>
 *         &lt;element name="partie" type="{http://pds.m1.upec.fr/xml/presentation2metier}PartieP2M"/>
 *         &lt;element name="listeDes" type="{http://pds.m1.upec.fr/xml/presentation2metier}ListeDesP2M"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JeuP2M", propOrder = {
    "listeJoueurs",
    "partie",
    "listeDes"
})
public class JeuP2M {

    @XmlElement(required = true)
    protected ListeJoueursP2M listeJoueurs;
    @XmlElement(required = true)
    protected PartieP2M partie;
    @XmlElement(required = true)
    protected ListeDesP2M listeDes;

    /**
     * Obtient la valeur de la propriété listeJoueurs.
     * 
     * @return
     *     possible object is
     *     {@link ListeJoueursP2M }
     *     
     */
    public ListeJoueursP2M getListeJoueurs() {
        return listeJoueurs;
    }

    /**
     * Définit la valeur de la propriété listeJoueurs.
     * 
     * @param value
     *     allowed object is
     *     {@link ListeJoueursP2M }
     *     
     */
    public void setListeJoueurs(ListeJoueursP2M value) {
        this.listeJoueurs = value;
    }

    /**
     * Obtient la valeur de la propriété partie.
     * 
     * @return
     *     possible object is
     *     {@link PartieP2M }
     *     
     */
    public PartieP2M getPartie() {
        return partie;
    }

    /**
     * Définit la valeur de la propriété partie.
     * 
     * @param value
     *     allowed object is
     *     {@link PartieP2M }
     *     
     */
    public void setPartie(PartieP2M value) {
        this.partie = value;
    }

    /**
     * Obtient la valeur de la propriété listeDes.
     * 
     * @return
     *     possible object is
     *     {@link ListeDesP2M }
     *     
     */
    public ListeDesP2M getListeDes() {
        return listeDes;
    }

    /**
     * Définit la valeur de la propriété listeDes.
     * 
     * @param value
     *     allowed object is
     *     {@link ListeDesP2M }
     *     
     */
    public void setListeDes(ListeDesP2M value) {
        this.listeDes = value;
    }

}
