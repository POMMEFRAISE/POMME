//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2016.05.06 � 10:21:48 PM CEST 
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
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://pds.m1.upec.fr/xml/metier2presentation}ReponseHeadM2P">
 *       &lt;sequence>
 *         &lt;element name="commande" type="{http://pds.m1.upec.fr/xml/metier2presentation}CommandeM2P"/>
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
    "commande"
})
@XmlRootElement(name = "reponseDemanderAuthentificationM2P")
public class ReponseDemanderAuthentificationM2P
    extends ReponseHeadM2P
{

    @XmlElement(required = true)
    protected CommandeM2P commande;

    /**
     * Obtient la valeur de la propri�t� commande.
     * 
     * @return
     *     possible object is
     *     {@link CommandeM2P }
     *     
     */
    public CommandeM2P getCommande() {
        return commande;
    }

    /**
     * D�finit la valeur de la propri�t� commande.
     * 
     * @param value
     *     allowed object is
     *     {@link CommandeM2P }
     *     
     */
    public void setCommande(CommandeM2P value) {
        this.commande = value;
    }

}
