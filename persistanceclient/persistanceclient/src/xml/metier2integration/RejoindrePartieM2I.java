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
 *         &lt;element name="rejoindreUnePartie" type="{http://pds.m1.upec.fr/xml/metier2integration}RejoindreUnePartieM2I"/>
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
@XmlRootElement(name = "rejoindrePartieM2I")
public class RejoindrePartieM2I
    extends RequeteHeadM2I
{

    @XmlElement(required = true)
    protected RejoindreUnePartieM2I rejoindreUnePartie;

    /**
     * Obtient la valeur de la propri�t� rejoindreUnePartie.
     * 
     * @return
     *     possible object is
     *     {@link RejoindreUnePartieM2I }
     *     
     */
    public RejoindreUnePartieM2I getRejoindreUnePartie() {
        return rejoindreUnePartie;
    }

    /**
     * D�finit la valeur de la propri�t� rejoindreUnePartie.
     * 
     * @param value
     *     allowed object is
     *     {@link RejoindreUnePartieM2I }
     *     
     */
    public void setRejoindreUnePartie(RejoindreUnePartieM2I value) {
        this.rejoindreUnePartie = value;
    }

}
