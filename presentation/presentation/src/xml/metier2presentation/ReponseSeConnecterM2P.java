//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2016.04.20 � 07:22:08 PM CEST 
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
 *     &lt;extension base="{http://pds.m1.upec.fr/xml/integration2metier}ReponseHeadM2P">
 *       &lt;sequence>
 *         &lt;element name="Authentification" type="{http://pds.m1.upec.fr/xml/integration2metier}AuthentificationM2P"/>
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
@XmlRootElement(name = "reponseSeConnecterM2P")
public class ReponseSeConnecterM2P
    extends ReponseHeadM2P
{

    @XmlElement(name = "Authentification", required = true)
    protected AuthentificationM2P authentification;

    /**
     * Obtient la valeur de la propri�t� authentification.
     * 
     * @return
     *     possible object is
     *     {@link AuthentificationM2P }
     *     
     */
    public AuthentificationM2P getAuthentification() {
        return authentification;
    }

    /**
     * D�finit la valeur de la propri�t� authentification.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthentificationM2P }
     *     
     */
    public void setAuthentification(AuthentificationM2P value) {
        this.authentification = value;
    }

}
