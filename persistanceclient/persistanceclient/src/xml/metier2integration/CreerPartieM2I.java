//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2016.05.07 � 01:04:16 AM CEST 
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
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://pds.m1.upec.fr/xml/metier2integration}RequeteHeadM2I">
 *       &lt;sequence>
 *         &lt;element name="creationPartie" type="{http://pds.m1.upec.fr/xml/metier2integration}CreationPartieM2I"/>
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
@XmlRootElement(name = "creerPartieM2I")
public class CreerPartieM2I
    extends RequeteHeadM2I
{

    @XmlElement(required = true)
    protected CreationPartieM2I creationPartie;

    /**
     * Obtient la valeur de la propri�t� creationPartie.
     * 
     * @return
     *     possible object is
     *     {@link CreationPartieM2I }
     *     
     */
    public CreationPartieM2I getCreationPartie() {
        return creationPartie;
    }

    /**
     * D�finit la valeur de la propri�t� creationPartie.
     * 
     * @param value
     *     allowed object is
     *     {@link CreationPartieM2I }
     *     
     */
    public void setCreationPartie(CreationPartieM2I value) {
        this.creationPartie = value;
    }

}
