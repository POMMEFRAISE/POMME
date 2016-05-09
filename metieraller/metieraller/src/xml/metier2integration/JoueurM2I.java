//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.05.09 à 12:02:12 AM CEST 
//


package xml.metier2integration;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour JoueurM2I complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="JoueurM2I">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="joueurGauche" type="{http://pds.m1.upec.fr/xml/metier2integration}JoueurM2I"/>
 *         &lt;element name="joueurDroite" type="{http://pds.m1.upec.fr/xml/metier2integration}JoueurM2I"/>
 *       &lt;/sequence>
 *       &lt;attribute name="nomJoueur" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="prenomJoueur" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="loginJoueur" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="positionJeu" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="resultatPremierLancer" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="doitJoueur" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="numeroPresentation" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JoueurM2I", propOrder = {
    "joueurGauche",
    "joueurDroite"
})
public class JoueurM2I {

    @XmlElement(required = true)
    protected JoueurM2I joueurGauche;
    @XmlElement(required = true)
    protected JoueurM2I joueurDroite;
    @XmlAttribute(name = "nomJoueur")
    protected String nomJoueur;
    @XmlAttribute(name = "prenomJoueur")
    protected String prenomJoueur;
    @XmlAttribute(name = "loginJoueur")
    protected String loginJoueur;
    @XmlAttribute(name = "positionJeu")
    protected Integer positionJeu;
    @XmlAttribute(name = "resultatPremierLancer")
    protected Integer resultatPremierLancer;
    @XmlAttribute(name = "doitJoueur")
    protected Boolean doitJoueur;
    @XmlAttribute(name = "numeroPresentation")
    protected Integer numeroPresentation;

    /**
     * Obtient la valeur de la propriété joueurGauche.
     * 
     * @return
     *     possible object is
     *     {@link JoueurM2I }
     *     
     */
    public JoueurM2I getJoueurGauche() {
        return joueurGauche;
    }

    /**
     * Définit la valeur de la propriété joueurGauche.
     * 
     * @param value
     *     allowed object is
     *     {@link JoueurM2I }
     *     
     */
    public void setJoueurGauche(JoueurM2I value) {
        this.joueurGauche = value;
    }

    /**
     * Obtient la valeur de la propriété joueurDroite.
     * 
     * @return
     *     possible object is
     *     {@link JoueurM2I }
     *     
     */
    public JoueurM2I getJoueurDroite() {
        return joueurDroite;
    }

    /**
     * Définit la valeur de la propriété joueurDroite.
     * 
     * @param value
     *     allowed object is
     *     {@link JoueurM2I }
     *     
     */
    public void setJoueurDroite(JoueurM2I value) {
        this.joueurDroite = value;
    }

    /**
     * Obtient la valeur de la propriété nomJoueur.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomJoueur() {
        return nomJoueur;
    }

    /**
     * Définit la valeur de la propriété nomJoueur.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomJoueur(String value) {
        this.nomJoueur = value;
    }

    /**
     * Obtient la valeur de la propriété prenomJoueur.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrenomJoueur() {
        return prenomJoueur;
    }

    /**
     * Définit la valeur de la propriété prenomJoueur.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrenomJoueur(String value) {
        this.prenomJoueur = value;
    }

    /**
     * Obtient la valeur de la propriété loginJoueur.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginJoueur() {
        return loginJoueur;
    }

    /**
     * Définit la valeur de la propriété loginJoueur.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginJoueur(String value) {
        this.loginJoueur = value;
    }

    /**
     * Obtient la valeur de la propriété positionJeu.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPositionJeu() {
        return positionJeu;
    }

    /**
     * Définit la valeur de la propriété positionJeu.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPositionJeu(Integer value) {
        this.positionJeu = value;
    }

    /**
     * Obtient la valeur de la propriété resultatPremierLancer.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getResultatPremierLancer() {
        return resultatPremierLancer;
    }

    /**
     * Définit la valeur de la propriété resultatPremierLancer.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setResultatPremierLancer(Integer value) {
        this.resultatPremierLancer = value;
    }

    /**
     * Obtient la valeur de la propriété doitJoueur.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDoitJoueur() {
        return doitJoueur;
    }

    /**
     * Définit la valeur de la propriété doitJoueur.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDoitJoueur(Boolean value) {
        this.doitJoueur = value;
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
