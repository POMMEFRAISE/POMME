//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.05.07 à 02:57:33 PM CEST 
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
 *         &lt;element name="listeJeux" type="{http://pds.m1.upec.fr/xml/integration2metier}ListeJeuxI2M"/>
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
    "listeJeux"
})
@XmlRootElement(name = "reponseAvertirCommencerJeuI2M")
public class ReponseAvertirCommencerJeuI2M
    extends ReponseHeadI2M
{

    @XmlElement(required = true)
    protected ListeJeuxI2M listeJeux;

    /**
     * Obtient la valeur de la propriété listeJeux.
     * 
     * @return
     *     possible object is
     *     {@link ListeJeuxI2M }
     *     
     */
    public ListeJeuxI2M getListeJeux() {
        return listeJeux;
    }

    /**
     * Définit la valeur de la propriété listeJeux.
     * 
     * @param value
     *     allowed object is
     *     {@link ListeJeuxI2M }
     *     
     */
    public void setListeJeux(ListeJeuxI2M value) {
        this.listeJeux = value;
    }

}
