//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2016.05.09 � 12:03:57 AM CEST 
//


package xml.integration2metier;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour JoueurI2M complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="JoueurI2M">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="joueurGauche" type="{http://pds.m1.upec.fr/xml/integration2metier}JoueurI2M"/>
 *         &lt;element name="joueurDroite" type="{http://pds.m1.upec.fr/xml/integration2metier}JoueurI2M"/>
 *       &lt;/sequence>
 *       &lt;attribute name="nomJoueur" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="prenomJoueur" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="loginJoueur" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="numeroPresentation" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="positionJeu" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="doitJoueur" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="resultatPremierLancer" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JoueurI2M", propOrder = {
    "joueurGauche",
    "joueurDroite"
})
public class JoueurI2M {

    @XmlElement(required = true)
    protected JoueurI2M joueurGauche;
    @XmlElement(required = true)
    protected JoueurI2M joueurDroite;
    @XmlAttribute(name = "nomJoueur")
    protected String nomJoueur;
    @XmlAttribute(name = "prenomJoueur")
    protected String prenomJoueur;
    @XmlAttribute(name = "loginJoueur")
    protected String loginJoueur;
    @XmlAttribute(name = "numeroPresentation")
    protected Integer numeroPresentation;
    @XmlAttribute(name = "positionJeu")
    protected Integer positionJeu;
    @XmlAttribute(name = "doitJoueur")
    protected Boolean doitJoueur;
    @XmlAttribute(name = "resultatPremierLancer")
    protected Integer resultatPremierLancer;

    /**
     * Obtient la valeur de la propri�t� joueurGauche.
     * 
     * @return
     *     possible object is
     *     {@link JoueurI2M }
     *     
     */
    public JoueurI2M getJoueurGauche() {
        return joueurGauche;
    }

    /**
     * D�finit la valeur de la propri�t� joueurGauche.
     * 
     * @param value
     *     allowed object is
     *     {@link JoueurI2M }
     *     
     */
    public void setJoueurGauche(JoueurI2M value) {
        this.joueurGauche = value;
    }

    /**
     * Obtient la valeur de la propri�t� joueurDroite.
     * 
     * @return
     *     possible object is
     *     {@link JoueurI2M }
     *     
     */
    public JoueurI2M getJoueurDroite() {
        return joueurDroite;
    }

    /**
     * D�finit la valeur de la propri�t� joueurDroite.
     * 
     * @param value
     *     allowed object is
     *     {@link JoueurI2M }
     *     
     */
    public void setJoueurDroite(JoueurI2M value) {
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

    /**
     * Obtient la valeur de la propri�t� resultatPremierLancer.
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

}
