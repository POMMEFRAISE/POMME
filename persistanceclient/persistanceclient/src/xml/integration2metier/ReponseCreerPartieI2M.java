//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2016.05.08 � 08:11:14 PM CEST 
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
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://pds.m1.upec.fr/xml/integration2metier}ReponseHeadI2M">
 *       &lt;sequence>
 *         &lt;element name="creationPartie" type="{http://pds.m1.upec.fr/xml/integration2metier}CreationPartieI2M"/>
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
@XmlRootElement(name = "reponseCreerPartieI2M")
public class ReponseCreerPartieI2M
    extends ReponseHeadI2M
{

    @XmlElement(required = true)
    protected CreationPartieI2M creationPartie;

    /**
     * Obtient la valeur de la propri�t� creationPartie.
     * 
     * @return
     *     possible object is
     *     {@link CreationPartieI2M }
     *     
     */
    public CreationPartieI2M getCreationPartie() {
        return creationPartie;
    }

    /**
     * D�finit la valeur de la propri�t� creationPartie.
     * 
     * @param value
     *     allowed object is
     *     {@link CreationPartieI2M }
     *     
     */
    public void setCreationPartie(CreationPartieI2M value) {
        this.creationPartie = value;
    }

}
