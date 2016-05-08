//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2016.05.08 � 05:27:01 PM CEST 
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
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
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
     * Obtient la valeur de la propri�t� joueurGauche.
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
     * D�finit la valeur de la propri�t� joueurGauche.
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
     * Obtient la valeur de la propri�t� joueurDroite.
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
     * D�finit la valeur de la propri�t� joueurDroite.
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
     * Obtient la valeur de la propri�t� nomJoueur.
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
     * D�finit la valeur de la propri�t� nomJoueur.
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
     * Obtient la valeur de la propri�t� prenomJoueur.
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
     * D�finit la valeur de la propri�t� prenomJoueur.
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
     * Obtient la valeur de la propri�t� loginJoueur.
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
     * D�finit la valeur de la propri�t� loginJoueur.
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
     * Obtient la valeur de la propri�t� positionJeu.
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
     * D�finit la valeur de la propri�t� positionJeu.
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
     * Obtient la valeur de la propri�t� resultatPremierLancer.
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
     * D�finit la valeur de la propri�t� resultatPremierLancer.
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
     * Obtient la valeur de la propri�t� doitJoueur.
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
     * D�finit la valeur de la propri�t� doitJoueur.
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
