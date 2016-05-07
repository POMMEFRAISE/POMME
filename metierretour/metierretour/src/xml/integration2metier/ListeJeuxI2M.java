//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.05.07 à 03:07:39 PM CEST 
//


package xml.integration2metier;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour ListeJeuxI2M complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="ListeJeuxI2M">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="listeJeux" type="{http://pds.m1.upec.fr/xml/integration2metier}JeuI2M" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListeJeuxI2M", propOrder = {
    "listeJeux"
})
public class ListeJeuxI2M {

    protected List<JeuI2M> listeJeux;

    /**
     * Gets the value of the listeJeux property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listeJeux property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListeJeux().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JeuI2M }
     * 
     * 
     */
    public List<JeuI2M> getListeJeux() {
        if (listeJeux == null) {
            listeJeux = new ArrayList<JeuI2M>();
        }
        return this.listeJeux;
    }

}
