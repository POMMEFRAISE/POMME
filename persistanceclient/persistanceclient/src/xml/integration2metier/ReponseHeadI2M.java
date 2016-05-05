//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2016.05.05 � 09:30:37 PM CEST 
//


package xml.integration2metier;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour ReponseHeadI2M complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="ReponseHeadI2M">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="statutMessage" type="{http://www.w3.org/2001/XMLSchema}string" default="Trait�e" />
 *       &lt;attribute name="dateCreationMessage" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="idMessageMetier2Integration" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="numeroPresentation" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReponseHeadI2M")
@XmlSeeAlso({
    ReponseDemanderCreerPartieI2M.class,
    ReponseDemanderAuthentificationI2M.class,
    ReponseDemanderNumeroPresentationI2M.class,
    ReponseSeConnecterI2M.class,
    ReponseCreerPartieI2M.class
})
public abstract class ReponseHeadI2M {

    @XmlAttribute(name = "statutMessage")
    protected String statutMessage;
    @XmlAttribute(name = "dateCreationMessage")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateCreationMessage;
    @XmlAttribute(name = "idMessageMetier2Integration")
    protected String idMessageMetier2Integration;
    @XmlAttribute(name = "numeroPresentation")
    protected Integer numeroPresentation;

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
            return "Trait\u00e9e";
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
     * Obtient la valeur de la propri�t� idMessageMetier2Integration.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdMessageMetier2Integration() {
        return idMessageMetier2Integration;
    }

    /**
     * D�finit la valeur de la propri�t� idMessageMetier2Integration.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdMessageMetier2Integration(String value) {
        this.idMessageMetier2Integration = value;
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
