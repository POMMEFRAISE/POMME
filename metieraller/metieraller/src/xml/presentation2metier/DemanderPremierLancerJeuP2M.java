//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2016.05.09 � 12:01:37 AM CEST 
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
 *         &lt;element name="jeu" type="{http://pds.m1.upec.fr/xml/presentation2metier}JeuP2M"/>
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
@XmlRootElement(name = "demanderPremierLancerJeuP2M")
public class DemanderPremierLancerJeuP2M
    extends RequeteHeadP2M
{

    @XmlElement(required = true)
    protected JeuP2M jeu;

    /**
     * Obtient la valeur de la propri�t� jeu.
     * 
     * @return
     *     possible object is
     *     {@link JeuP2M }
     *     
     */
    public JeuP2M getJeu() {
        return jeu;
    }

    /**
     * D�finit la valeur de la propri�t� jeu.
     * 
     * @param value
     *     allowed object is
     *     {@link JeuP2M }
     *     
     */
    public void setJeu(JeuP2M value) {
        this.jeu = value;
    }

}
