//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2016.05.09 � 12:04:11 AM CEST 
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
 *         &lt;element name="jeu" type="{http://pds.m1.upec.fr/xml/integration2metier}JeuI2M"/>
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
    "jeu"
})
@XmlRootElement(name = "reponseRejoindrePartieI2M")
public class ReponseRejoindrePartieI2M
    extends ReponseHeadI2M
{

    @XmlElement(required = true)
    protected JeuI2M jeu;

    /**
     * Obtient la valeur de la propri�t� jeu.
     * 
     * @return
     *     possible object is
     *     {@link JeuI2M }
     *     
     */
    public JeuI2M getJeu() {
        return jeu;
    }

    /**
     * D�finit la valeur de la propri�t� jeu.
     * 
     * @param value
     *     allowed object is
     *     {@link JeuI2M }
     *     
     */
    public void setJeu(JeuI2M value) {
        this.jeu = value;
    }

}
