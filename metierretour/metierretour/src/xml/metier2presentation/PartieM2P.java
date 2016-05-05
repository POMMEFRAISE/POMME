//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.05.05 à 09:50:52 PM CEST 
//


package xml.metier2presentation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour PartieM2P complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="PartieM2P">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="nomPartie" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="nbJoueurPartie" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PartieM2P")
public class PartieM2P {

    @XmlAttribute(name = "nomPartie")
    protected String nomPartie;
    @XmlAttribute(name = "nbJoueurPartie")
    protected Integer nbJoueurPartie;

    /**
     * Obtient la valeur de la propriété nomPartie.
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
     * Définit la valeur de la propriété nomPartie.
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
     * Obtient la valeur de la propriété nbJoueurPartie.
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
     * Définit la valeur de la propriété nbJoueurPartie.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNbJoueurPartie(Integer value) {
        this.nbJoueurPartie = value;
    }

}
