//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2016.05.07 � 01:00:50 AM CEST 
//


package xml.metier2integration;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour RejoindreUnePartieM2I complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
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
     * Obtient la valeur de la propri�t� joueur.
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
     * D�finit la valeur de la propri�t� joueur.
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
     * Obtient la valeur de la propri�t� partie.
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
     * D�finit la valeur de la propri�t� partie.
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
