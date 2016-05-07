//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.05.07 à 01:00:33 AM CEST 
//


package xml.presentation2metier;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour RejoindreUnePartieP2M complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="RejoindreUnePartieP2M">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="joueur" type="{http://pds.m1.upec.fr/xml/presentation2metier}JoueurP2M"/>
 *         &lt;element name="partie" type="{http://pds.m1.upec.fr/xml/presentation2metier}PartieP2M"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RejoindreUnePartieP2M", propOrder = {
    "joueur",
    "partie"
})
public class RejoindreUnePartieP2M {

    @XmlElement(required = true)
    protected JoueurP2M joueur;
    @XmlElement(required = true)
    protected PartieP2M partie;

    /**
     * Obtient la valeur de la propriété joueur.
     * 
     * @return
     *     possible object is
     *     {@link JoueurP2M }
     *     
     */
    public JoueurP2M getJoueur() {
        return joueur;
    }

    /**
     * Définit la valeur de la propriété joueur.
     * 
     * @param value
     *     allowed object is
     *     {@link JoueurP2M }
     *     
     */
    public void setJoueur(JoueurP2M value) {
        this.joueur = value;
    }

    /**
     * Obtient la valeur de la propriété partie.
     * 
     * @return
     *     possible object is
     *     {@link PartieP2M }
     *     
     */
    public PartieP2M getPartie() {
        return partie;
    }

    /**
     * Définit la valeur de la propriété partie.
     * 
     * @param value
     *     allowed object is
     *     {@link PartieP2M }
     *     
     */
    public void setPartie(PartieP2M value) {
        this.partie = value;
    }

}
