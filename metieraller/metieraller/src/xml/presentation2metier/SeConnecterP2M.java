//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.05.06 à 10:23:45 PM CEST 
//


package xml.presentation2metier;

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
 *     &lt;extension base="{http://pds.m1.upec.fr/xml/presentation2metier}RequeteHeadP2M">
 *       &lt;sequence>
 *         &lt;element name="authentification" type="{http://pds.m1.upec.fr/xml/presentation2metier}AuthentificationP2M"/>
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
@XmlRootElement(name = "seConnecterP2M")
public class SeConnecterP2M
    extends RequeteHeadP2M
{

    @XmlElement(required = true)
    protected AuthentificationP2M authentification;

    /**
     * Obtient la valeur de la propriété authentification.
     * 
     * @return
     *     possible object is
     *     {@link AuthentificationP2M }
     *     
     */
    public AuthentificationP2M getAuthentification() {
        return authentification;
    }

    /**
     * Définit la valeur de la propriété authentification.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthentificationP2M }
     *     
     */
    public void setAuthentification(AuthentificationP2M value) {
        this.authentification = value;
    }

}
