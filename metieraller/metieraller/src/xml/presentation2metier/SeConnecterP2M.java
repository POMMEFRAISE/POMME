//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2016.05.06 � 10:23:45 PM CEST 
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
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://pds.m1.upec.fr/xml/presentation2metier}RequeteHeadP2M">
 *       &lt;sequence>
 *         &lt;element name="authentification" type="{http://pds.m1.upec.fr/xml/presentation2metier}AuthentificationP2M"/>
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
    "authentification"
})
@XmlRootElement(name = "seConnecterP2M")
public class SeConnecterP2M
    extends RequeteHeadP2M
{

    @XmlElement(required = true)
    protected AuthentificationP2M authentification;

    /**
     * Obtient la valeur de la propri�t� authentification.
     * 
     * @return
     *     possible object is
     *     {@link AuthentificationP2M }
     *     
     */
    public AuthentificationP2M getAuthentification() {
        return authentification;
    }

    /**
     * D�finit la valeur de la propri�t� authentification.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthentificationP2M }
     *     
     */
    public void setAuthentification(AuthentificationP2M value) {
        this.authentification = value;
    }

}
