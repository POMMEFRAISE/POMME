//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.05.08 à 08:11:34 PM CEST 
//


package xml.integration2metier;

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
 *     &lt;extension base="{http://pds.m1.upec.fr/xml/integration2metier}ReponseHeadI2M">
 *       &lt;sequence>
 *         &lt;element name="listeParties" type="{http://pds.m1.upec.fr/xml/integration2metier}ListePartiesI2M"/>
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
    "listeParties"
})
@XmlRootElement(name = "reponseObtenirListePartiesI2M")
public class ReponseObtenirListePartiesI2M
    extends ReponseHeadI2M
{

    @XmlElement(required = true)
    protected ListePartiesI2M listeParties;

    /**
     * Obtient la valeur de la propriété listeParties.
     * 
     * @return
     *     possible object is
     *     {@link ListePartiesI2M }
     *     
     */
    public ListePartiesI2M getListeParties() {
        return listeParties;
    }

    /**
     * Définit la valeur de la propriété listeParties.
     * 
     * @param value
     *     allowed object is
     *     {@link ListePartiesI2M }
     *     
     */
    public void setListeParties(ListePartiesI2M value) {
        this.listeParties = value;
    }

}
