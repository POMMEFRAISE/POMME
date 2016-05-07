//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.05.07 à 03:07:27 PM CEST 
//


package xml.metier2presentation;

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
 *     &lt;extension base="{http://pds.m1.upec.fr/xml/metier2presentation}ReponseHeadM2P">
 *       &lt;sequence>
 *         &lt;element name="listeParties" type="{http://pds.m1.upec.fr/xml/metier2presentation}ListePartiesM2P"/>
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
@XmlRootElement(name = "reponseObtenirListePartiesM2P")
public class ReponseObtenirListePartiesM2P
    extends ReponseHeadM2P
{

    @XmlElement(required = true)
    protected ListePartiesM2P listeParties;

    /**
     * Obtient la valeur de la propriété listeParties.
     * 
     * @return
     *     possible object is
     *     {@link ListePartiesM2P }
     *     
     */
    public ListePartiesM2P getListeParties() {
        return listeParties;
    }

    /**
     * Définit la valeur de la propriété listeParties.
     * 
     * @param value
     *     allowed object is
     *     {@link ListePartiesM2P }
     *     
     */
    public void setListeParties(ListePartiesM2P value) {
        this.listeParties = value;
    }

}
