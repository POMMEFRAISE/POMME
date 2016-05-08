//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.05.08 à 05:27:01 PM CEST 
//


package xml.metier2presentation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour JoueurM2P complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="JoueurM2P">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="joueurGauche" type="{http://pds.m1.upec.fr/xml/metier2presentation}JoueurM2P"/>
 *         &lt;element name="joueurDroite" type="{http://pds.m1.upec.fr/xml/metier2presentation}JoueurM2P"/>
 *       &lt;/sequence>
 *       &lt;attribute name="nomJoueur" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="prenomJoueur" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="loginJoueur" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="positionJeu" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="resultatPremierLancer" type="{http://www.w3.org/2001/XMLSchema}int" default="0" />
 *       &lt;attribute name="doitJoueur" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JoueurM2P", propOrder = {
    "joueurGauche",
    "joueurDroite"
})
public class JoueurM2P {

    @XmlElement(required = true)
    protected JoueurM2P joueurGauche;
    @XmlElement(required = true)
    protected JoueurM2P joueurDroite;
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

    /**
     * Obtient la valeur de la propriété joueurGauche.
     * 
     * @return
     *     possible object is
     *     {@link JoueurM2P }
     *     
     */
    public JoueurM2P getJoueurGauche() {
        return joueurGauche;
    }

    /**
     * Définit la valeur de la propriété joueurGauche.
     * 
     * @param value
     *     allowed object is
     *     {@link JoueurM2P }
     *     
     */
    public void setJoueurGauche(JoueurM2P value) {
        this.joueurGauche = value;
    }

    /**
     * Obtient la valeur de la propriété joueurDroite.
     * 
     * @return
     *     possible object is
     *     {@link JoueurM2P }
     *     
     */
    public JoueurM2P getJoueurDroite() {
        return joueurDroite;
    }

    /**
     * Définit la valeur de la propriété joueurDroite.
     * 
     * @param value
     *     allowed object is
     *     {@link JoueurM2P }
     *     
     */
    public void setJoueurDroite(JoueurM2P value) {
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
    public int getResultatPremierLancer() {
        if (resultatPremierLancer == null) {
            return  0;
        } else {
            return resultatPremierLancer;
        }
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

}
