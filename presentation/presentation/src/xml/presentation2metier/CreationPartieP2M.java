//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2016.05.05 � 09:08:57 PM CEST 
//


package xml.presentation2metier;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour CreationPartieP2M complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="CreationPartieP2M">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="nomParrtie" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="nbJoueurPartie" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreationPartieP2M")
public class CreationPartieP2M {

    @XmlAttribute(name = "nomParrtie")
    protected String nomParrtie;
    @XmlAttribute(name = "nbJoueurPartie")
    protected Integer nbJoueurPartie;

    /**
     * Obtient la valeur de la propri�t� nomParrtie.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomParrtie() {
        return nomParrtie;
    }

    /**
     * D�finit la valeur de la propri�t� nomParrtie.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomParrtie(String value) {
        this.nomParrtie = value;
    }

    /**
     * Obtient la valeur de la propri�t� nbJoueurPartie.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNbJoueurPartie() {
        return nbJoueurPartie;
    }

    /**
     * D�finit la valeur de la propri�t� nbJoueurPartie.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNbJoueurPartie(Integer value) {
        this.nbJoueurPartie = value;
    }

}
