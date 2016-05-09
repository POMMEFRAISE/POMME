//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.05.09 à 12:02:12 AM CEST 
//


package xml.metier2integration;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour JeuM2I complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="JeuM2I">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="listeJoueurs" type="{http://pds.m1.upec.fr/xml/metier2integration}ListeJoueursM2I"/>
 *         &lt;element name="partie" type="{http://pds.m1.upec.fr/xml/metier2integration}PartieM2I"/>
 *         &lt;element name="listeDes" type="{http://pds.m1.upec.fr/xml/metier2integration}ListeDesM2I"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JeuM2I", propOrder = {
    "listeJoueurs",
    "partie",
    "listeDes"
})
public class JeuM2I {

    @XmlElement(required = true)
    protected ListeJoueursM2I listeJoueurs;
    @XmlElement(required = true)
    protected PartieM2I partie;
    @XmlElement(required = true)
    protected ListeDesM2I listeDes;

    /**
     * Obtient la valeur de la propriété listeJoueurs.
     * 
     * @return
     *     possible object is
     *     {@link ListeJoueursM2I }
     *     
     */
    public ListeJoueursM2I getListeJoueurs() {
        return listeJoueurs;
    }

    /**
     * Définit la valeur de la propriété listeJoueurs.
     * 
     * @param value
     *     allowed object is
     *     {@link ListeJoueursM2I }
     *     
     */
    public void setListeJoueurs(ListeJoueursM2I value) {
        this.listeJoueurs = value;
    }

    /**
     * Obtient la valeur de la propriété partie.
     * 
     * @return
     *     possible object is
     *     {@link PartieM2I }
     *     
     */
    public PartieM2I getPartie() {
        return partie;
    }

    /**
     * Définit la valeur de la propriété partie.
     * 
     * @param value
     *     allowed object is
     *     {@link PartieM2I }
     *     
     */
    public void setPartie(PartieM2I value) {
        this.partie = value;
    }

    /**
     * Obtient la valeur de la propriété listeDes.
     * 
     * @return
     *     possible object is
     *     {@link ListeDesM2I }
     *     
     */
    public ListeDesM2I getListeDes() {
        return listeDes;
    }

    /**
     * Définit la valeur de la propriété listeDes.
     * 
     * @param value
     *     allowed object is
     *     {@link ListeDesM2I }
     *     
     */
    public void setListeDes(ListeDesM2I value) {
        this.listeDes = value;
    }

}
