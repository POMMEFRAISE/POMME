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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour JeuP2M complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="JeuP2M">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="listeJoueurs" type="{http://pds.m1.upec.fr/xml/presentation2metier}ListeJoueursP2M"/>
 *         &lt;element name="partie" type="{http://pds.m1.upec.fr/xml/presentation2metier}PartieP2M"/>
 *         &lt;element name="listeDes" type="{http://pds.m1.upec.fr/xml/presentation2metier}ListeDesP2M"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JeuP2M", propOrder = {
    "listeJoueurs",
    "partie",
    "listeDes"
})
public class JeuP2M {

    @XmlElement(required = true)
    protected ListeJoueursP2M listeJoueurs;
    @XmlElement(required = true)
    protected PartieP2M partie;
    @XmlElement(required = true)
    protected ListeDesP2M listeDes;

    /**
     * Obtient la valeur de la propri�t� listeJoueurs.
     * 
     * @return
     *     possible object is
     *     {@link ListeJoueursP2M }
     *     
     */
    public ListeJoueursP2M getListeJoueurs() {
        return listeJoueurs;
    }

    /**
     * D�finit la valeur de la propri�t� listeJoueurs.
     * 
     * @param value
     *     allowed object is
     *     {@link ListeJoueursP2M }
     *     
     */
    public void setListeJoueurs(ListeJoueursP2M value) {
        this.listeJoueurs = value;
    }

    /**
     * Obtient la valeur de la propri�t� partie.
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
     * D�finit la valeur de la propri�t� partie.
     * 
     * @param value
     *     allowed object is
     *     {@link PartieP2M }
     *     
     */
    public void setPartie(PartieP2M value) {
        this.partie = value;
    }

    /**
     * Obtient la valeur de la propri�t� listeDes.
     * 
     * @return
     *     possible object is
     *     {@link ListeDesP2M }
     *     
     */
    public ListeDesP2M getListeDes() {
        return listeDes;
    }

    /**
     * D�finit la valeur de la propri�t� listeDes.
     * 
     * @param value
     *     allowed object is
     *     {@link ListeDesP2M }
     *     
     */
    public void setListeDes(ListeDesP2M value) {
        this.listeDes = value;
    }

}
