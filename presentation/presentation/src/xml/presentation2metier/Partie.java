//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.04.12 à 06:37:48 PM CEST 
//


package xml.presentation2metier;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour Partie complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="Partie">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="listeJoueurs" type="{http://pds.m1.upec.fr/xml/presentation2metier}Joueur" maxOccurs="7"/>
 *         &lt;element name="listeDe" type="{http://pds.m1.upec.fr/xml/presentation2metier}De" maxOccurs="5"/>
 *       &lt;/sequence>
 *       &lt;attribute name="nomPartie" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="nbJoueur" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="statutPartie" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="dateCreationPartie" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Partie", propOrder = {
    "listeJoueurs",
    "listeDe"
})
public class Partie {

    @XmlElement(required = true)
    protected List<Joueur> listeJoueurs;
    @XmlElement(required = true)
    protected List<De> listeDe;
    @XmlAttribute(name = "nomPartie")
    protected String nomPartie;
    @XmlAttribute(name = "nbJoueur")
    protected String nbJoueur;
    @XmlAttribute(name = "statutPartie")
    protected String statutPartie;
    @XmlAttribute(name = "dateCreationPartie")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateCreationPartie;

    /**
     * Gets the value of the listeJoueurs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listeJoueurs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListeJoueurs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Joueur }
     * 
     * 
     */
    public List<Joueur> getListeJoueurs() {
        if (listeJoueurs == null) {
            listeJoueurs = new ArrayList<Joueur>();
        }
        return this.listeJoueurs;
    }

    /**
     * Gets the value of the listeDe property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listeDe property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListeDe().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link De }
     * 
     * 
     */
    public List<De> getListeDe() {
        if (listeDe == null) {
            listeDe = new ArrayList<De>();
        }
        return this.listeDe;
    }

    /**
     * Obtient la valeur de la propriété nomPartie.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomPartie() {
        return nomPartie;
    }

    /**
     * Définit la valeur de la propriété nomPartie.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomPartie(String value) {
        this.nomPartie = value;
    }

    /**
     * Obtient la valeur de la propriété nbJoueur.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNbJoueur() {
        return nbJoueur;
    }

    /**
     * Définit la valeur de la propriété nbJoueur.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNbJoueur(String value) {
        this.nbJoueur = value;
    }

    /**
     * Obtient la valeur de la propriété statutPartie.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatutPartie() {
        return statutPartie;
    }

    /**
     * Définit la valeur de la propriété statutPartie.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatutPartie(String value) {
        this.statutPartie = value;
    }

    /**
     * Obtient la valeur de la propriété dateCreationPartie.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateCreationPartie() {
        return dateCreationPartie;
    }

    /**
     * Définit la valeur de la propriété dateCreationPartie.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateCreationPartie(XMLGregorianCalendar value) {
        this.dateCreationPartie = value;
    }

}
