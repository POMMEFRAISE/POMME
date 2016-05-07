//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.05.07 à 01:00:50 AM CEST 
//


package xml.metier2integration;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour RejoindreUnePartieM2I complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="RejoindreUnePartieM2I">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="joueur" type="{http://pds.m1.upec.fr/xml/metier2integration}JoueurM2I"/>
 *         &lt;element name="partie" type="{http://pds.m1.upec.fr/xml/metier2integration}PartieM2I"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RejoindreUnePartieM2I", propOrder = {
    "joueur",
    "partie"
})
public class RejoindreUnePartieM2I {

    @XmlElement(required = true)
    protected JoueurM2I joueur;
    @XmlElement(required = true)
    protected PartieM2I partie;

    /**
     * Obtient la valeur de la propriété joueur.
     * 
     * @return
     *     possible object is
     *     {@link JoueurM2I }
     *     
     */
    public JoueurM2I getJoueur() {
        return joueur;
    }

    /**
     * Définit la valeur de la propriété joueur.
     * 
     * @param value
     *     allowed object is
     *     {@link JoueurM2I }
     *     
     */
    public void setJoueur(JoueurM2I value) {
        this.joueur = value;
    }

    /**
     * Obtient la valeur de la propriété partie.
     * 
     * @return
     *     possible object is
     *     {@link PartieM2I }
     *     
     */
    public PartieM2I getPartie() {
        return partie;
    }

    /**
     * Définit la valeur de la propriété partie.
     * 
     * @param value
     *     allowed object is
     *     {@link PartieM2I }
     *     
     */
    public void setPartie(PartieM2I value) {
        this.partie = value;
    }

}
