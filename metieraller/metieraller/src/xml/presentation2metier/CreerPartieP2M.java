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
 *         &lt;element name="creationPartie" type="{http://pds.m1.upec.fr/xml/presentation2metier}CreationPartieP2M"/>
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
    "creationPartie"
})
@XmlRootElement(name = "creerPartieP2M")
public class CreerPartieP2M
    extends RequeteHeadP2M
{

    @XmlElement(required = true)
    protected CreationPartieP2M creationPartie;

    /**
     * Obtient la valeur de la propriété creationPartie.
     * 
     * @return
     *     possible object is
     *     {@link CreationPartieP2M }
     *     
     */
    public CreationPartieP2M getCreationPartie() {
        return creationPartie;
    }

    /**
     * Définit la valeur de la propriété creationPartie.
     * 
     * @param value
     *     allowed object is
     *     {@link CreationPartieP2M }
     *     
     */
    public void setCreationPartie(CreationPartieP2M value) {
        this.creationPartie = value;
    }

}
