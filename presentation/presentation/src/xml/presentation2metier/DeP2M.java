//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.05.07 à 12:53:35 AM CEST 
//


package xml.presentation2metier;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour DeP2M complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="DeP2M">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="identifiantDe" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="resultatDe" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="positionDe" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeP2M")
public class DeP2M {

    @XmlAttribute(name = "identifiantDe")
    protected Integer identifiantDe;
    @XmlAttribute(name = "resultatDe")
    protected Integer resultatDe;
    @XmlAttribute(name = "positionDe")
    protected String positionDe;

    /**
     * Obtient la valeur de la propriété identifiantDe.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdentifiantDe() {
        return identifiantDe;
    }

    /**
     * Définit la valeur de la propriété identifiantDe.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdentifiantDe(Integer value) {
        this.identifiantDe = value;
    }

    /**
     * Obtient la valeur de la propriété resultatDe.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getResultatDe() {
        return resultatDe;
    }

    /**
     * Définit la valeur de la propriété resultatDe.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setResultatDe(Integer value) {
        this.resultatDe = value;
    }

    /**
     * Obtient la valeur de la propriété positionDe.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPositionDe() {
        return positionDe;
    }

    /**
     * Définit la valeur de la propriété positionDe.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPositionDe(String value) {
        this.positionDe = value;
    }

}
