//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.05.09 à 12:05:57 AM CEST 
//


package xml.metier2presentation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour ReponseHeadM2P complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="ReponseHeadM2P">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="statutMessage" type="{http://www.w3.org/2001/XMLSchema}string" />
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
@XmlType(name = "ReponseHeadM2P")
@XmlSeeAlso({
    ReponseDemanderNumeroPresentationM2P.class,
    ReponseDemanderPremierLancerJeuM2P.class,
    ReponseDemanderCreerPartieM2P.class,
    ReponseRejoindrePartieM2P.class,
    ReponseObtenirListePartiesM2P.class,
    ReponseAvertirCommencerJeuM2P.class,
    ReponseDemanderAuthentificationM2P.class,
    ReponseCreerPartieM2P.class,
    ReponseDemanderRejoindrePartieM2P.class,
    ReponseSeConnecterM2P.class
})
public abstract class ReponseHeadM2P {

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
     * Obtient la valeur de la propriété statutMessage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatutMessage() {
        return statutMessage;
    }

    /**
     * Définit la valeur de la propriété statutMessage.
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
     * Obtient la valeur de la propriété dateCreationMessage.
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
     * Définit la valeur de la propriété dateCreationMessage.
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
     * Obtient la valeur de la propriété idMessagePresentation2Metier.
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
     * Définit la valeur de la propriété idMessagePresentation2Metier.
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
     * Obtient la valeur de la propriété numeroPresentation.
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
     * Définit la valeur de la propriété numeroPresentation.
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
