//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2016.05.09 � 12:02:12 AM CEST 
//


package xml.metier2integration;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour JeuM2I complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="JeuM2I">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="listeJoueurs" type="{http://pds.m1.upec.fr/xml/metier2integration}ListeJoueursM2I"/>
 *         &lt;element name="partie" type="{http://pds.m1.upec.fr/xml/metier2integration}PartieM2I"/>
 *         &lt;element name="listeDes" type="{http://pds.m1.upec.fr/xml/metier2integration}ListeDesM2I"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JeuM2I", propOrder = {
    "listeJoueurs",
    "partie",
    "listeDes"
})
public class JeuM2I {

    @XmlElement(required = true)
    protected ListeJoueursM2I listeJoueurs;
    @XmlElement(required = true)
    protected PartieM2I partie;
    @XmlElement(required = true)
    protected ListeDesM2I listeDes;

    /**
     * Obtient la valeur de la propri�t� listeJoueurs.
     * 
     * @return
     *     possible object is
     *     {@link ListeJoueursM2I }
     *     
     */
    public ListeJoueursM2I getListeJoueurs() {
        return listeJoueurs;
    }

    /**
     * D�finit la valeur de la propri�t� listeJoueurs.
     * 
     * @param value
     *     allowed object is
     *     {@link ListeJoueursM2I }
     *     
     */
    public void setListeJoueurs(ListeJoueursM2I value) {
        this.listeJoueurs = value;
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

    /**
     * Obtient la valeur de la propri�t� listeDes.
     * 
     * @return
     *     possible object is
     *     {@link ListeDesM2I }
     *     
     */
    public ListeDesM2I getListeDes() {
        return listeDes;
    }

    /**
     * D�finit la valeur de la propri�t� listeDes.
     * 
     * @param value
     *     allowed object is
     *     {@link ListeDesM2I }
     *     
     */
    public void setListeDes(ListeDesM2I value) {
        this.listeDes = value;
    }

}
