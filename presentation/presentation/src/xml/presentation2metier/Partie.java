//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2016.04.12 � 06:37:48 PM CEST 
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
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
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
     * Obtient la valeur de la propri�t� nomPartie.
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
     * D�finit la valeur de la propri�t� nomPartie.
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
     * Obtient la valeur de la propri�t� nbJoueur.
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
     * D�finit la valeur de la propri�t� nbJoueur.
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
     * Obtient la valeur de la propri�t� statutPartie.
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
     * D�finit la valeur de la propri�t� statutPartie.
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
     * Obtient la valeur de la propri�t� dateCreationPartie.
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
     * D�finit la valeur de la propri�t� dateCreationPartie.
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
