//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2016.05.09 � 12:48:15 AM CEST 
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
 *         &lt;element name="creationPartie" type="{http://pds.m1.upec.fr/xml/metier2presentation}CreationPartieM2P"/>
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
@XmlRootElement(name = "reponseCreerPartieM2P")
public class ReponseCreerPartieM2P
    extends ReponseHeadM2P
{

    @XmlElement(required = true)
    protected CreationPartieM2P creationPartie;

    /**
     * Obtient la valeur de la propri�t� creationPartie.
     * 
     * @return
     *     possible object is
     *     {@link CreationPartieM2P }
     *     
     */
    public CreationPartieM2P getCreationPartie() {
        return creationPartie;
    }

    /**
     * D�finit la valeur de la propri�t� creationPartie.
     * 
     * @param value
     *     allowed object is
     *     {@link CreationPartieM2P }
     *     
     */
    public void setCreationPartie(CreationPartieM2P value) {
        this.creationPartie = value;
    }

}
