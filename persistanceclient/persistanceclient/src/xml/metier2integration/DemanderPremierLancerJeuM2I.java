//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.05.09 à 12:02:37 AM CEST 
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
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://pds.m1.upec.fr/xml/metier2integration}RequeteHeadM2I">
 *       &lt;sequence>
 *         &lt;element name="jeu" type="{http://pds.m1.upec.fr/xml/metier2integration}JeuM2I"/>
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
@XmlRootElement(name = "demanderPremierLancerJeuM2I")
public class DemanderPremierLancerJeuM2I
    extends RequeteHeadM2I
{

    @XmlElement(required = true)
    protected JeuM2I jeu;

    /**
     * Obtient la valeur de la propriété jeu.
     * 
     * @return
     *     possible object is
     *     {@link JeuM2I }
     *     
     */
    public JeuM2I getJeu() {
        return jeu;
    }

    /**
     * Définit la valeur de la propriété jeu.
     * 
     * @param value
     *     allowed object is
     *     {@link JeuM2I }
     *     
     */
    public void setJeu(JeuM2I value) {
        this.jeu = value;
    }

}
