//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.05.07 à 01:00:33 AM CEST 
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
 *         &lt;element name="rejoindreUnePartie" type="{http://pds.m1.upec.fr/xml/presentation2metier}RejoindreUnePartieP2M"/>
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
    "rejoindreUnePartie"
})
@XmlRootElement(name = "rejoindrePartieP2M")
public class RejoindrePartieP2M
    extends RequeteHeadP2M
{

    @XmlElement(required = true)
    protected RejoindreUnePartieP2M rejoindreUnePartie;

    /**
     * Obtient la valeur de la propriété rejoindreUnePartie.
     * 
     * @return
     *     possible object is
     *     {@link RejoindreUnePartieP2M }
     *     
     */
    public RejoindreUnePartieP2M getRejoindreUnePartie() {
        return rejoindreUnePartie;
    }

    /**
     * Définit la valeur de la propriété rejoindreUnePartie.
     * 
     * @param value
     *     allowed object is
     *     {@link RejoindreUnePartieP2M }
     *     
     */
    public void setRejoindreUnePartie(RejoindreUnePartieP2M value) {
        this.rejoindreUnePartie = value;
    }

}
