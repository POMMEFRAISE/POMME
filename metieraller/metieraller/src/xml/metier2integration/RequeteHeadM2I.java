//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2016.05.09 � 12:02:12 AM CEST 
//


package xml.metier2integration;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour RequeteHeadM2I complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="RequeteHeadM2I">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="idMessage" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="statutMessage" type="{http://www.w3.org/2001/XMLSchema}string" default="Cr��" />
 *       &lt;attribute name="dateCreationMessage" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="idMessagePresentation2Metier" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="numeroPresentation" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequeteHeadM2I")
@XmlSeeAlso({
    DemanderRejoindrePartieM2I.class,
    DemanderPremierLancerJeuM2I.class,
    DemanderCreerPartieM2I.class,
    RejoindrePartieM2I.class,
    SeConnecterM2I.class,
    CreerPartieM2I.class,
    DemanderNumeroPresentationM2I.class,
    ObtenirListePartiesM2I.class,
    DemanderAuthentificationM2I.class
})
public abstract class RequeteHeadM2I {

    @XmlAttribute(name = "idMessage")
    protected String idMessage;
    @XmlAttribute(name = "statutMessage")
    protected String statutMessage;
    @XmlAttribute(name = "dateCreationMessage")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateCreationMessage;
    @XmlAttribute(name = "idMessagePresentation2Metier")
    protected String idMessagePresentation2Metier;
    @XmlAttribute(name = "numeroPresentation")
    protected Integer numeroPresentation;

    /**
     * Obtient la valeur de la propri�t� idMessage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdMessage() {
        return idMessage;
    }

    /**
     * D�finit la valeur de la propri�t� idMessage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdMessage(String value) {
        this.idMessage = value;
    }

    /**
     * Obtient la valeur de la propri�t� statutMessage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatutMessage() {
        if (statutMessage == null) {
            return "Cr\u00e9\u00e9";
        } else {
            return statutMessage;
        }
    }

    /**
     * D�finit la valeur de la propri�t� statutMessage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatutMessage(String value) {
        this.statutMessage = value;
    }

    /**
     * Obtient la valeur de la propri�t� dateCreationMessage.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateCreationMessage() {
        return dateCreationMessage;
    }

    /**
     * D�finit la valeur de la propri�t� dateCreationMessage.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateCreationMessage(XMLGregorianCalendar value) {
        this.dateCreationMessage = value;
    }

    /**
     * Obtient la valeur de la propri�t� idMessagePresentation2Metier.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdMessagePresentation2Metier() {
        return idMessagePresentation2Metier;
    }

    /**
     * D�finit la valeur de la propri�t� idMessagePresentation2Metier.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdMessagePresentation2Metier(String value) {
        this.idMessagePresentation2Metier = value;
    }

    /**
     * Obtient la valeur de la propri�t� numeroPresentation.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumeroPresentation() {
        return numeroPresentation;
    }

    /**
     * D�finit la valeur de la propri�t� numeroPresentation.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumeroPresentation(Integer value) {
        this.numeroPresentation = value;
    }

}
