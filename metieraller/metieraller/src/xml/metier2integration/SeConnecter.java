//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.02.28 à 03:23:46 PM CET 
//


package xml.metier2integration;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://pds.m1.upec.fr/xml/metier2integration}RequeteHead">
 *       &lt;sequence>
 *         &lt;element name="Authentification" type="{http://pds.m1.upec.fr/xml/metier2integration}Authentification"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "authentification"
})
@XmlRootElement(name = "seConnecter")
public class SeConnecter
    extends RequeteHead
{

    @XmlElement(name = "Authentification", required = true)
    protected Authentification authentification;

    /**
     * Obtient la valeur de la propriété authentification.
     * 
     * @return
     *     possible object is
     *     {@link Authentification }
     *     
     */
    public Authentification getAuthentification() {
        return authentification;
    }

    /**
     * Définit la valeur de la propriété authentification.
     * 
     * @param value
     *     allowed object is
     *     {@link Authentification }
     *     
     */
    public void setAuthentification(Authentification value) {
        this.authentification = value;
    }

}
