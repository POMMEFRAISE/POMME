package dto;

import java.io.Serializable;





public class JoueurDTO implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected int id;
	
	protected String nom;
	protected String prenom;
	protected String email;
	protected String login;
	protected String motDePasse;
	protected Integer numeroPresentation;
	protected Integer positionJeu;
	protected Integer resultatPremierLancer;
	protected Boolean doitJouer;
	protected Object joueurGauche;
	protected Object joueurDroite;
	public JoueurDTO(int id, String nom, String prenom, String email, String login, String motDePasse) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.login = login;
		this.motDePasse = motDePasse;
	}
	public JoueurDTO(JoueurDTO joueur) {
		this.nom = joueur.nom;
		this.prenom = joueur.prenom;
		this.email = joueur.email;
		this.login = joueur.login;
		this.motDePasse = joueur.motDePasse;
	}
	
	public JoueurDTO() {
		this.nom = "";
		this.prenom = "";
		this.email = "";
		this.login = "";
		this.motDePasse = "";	}

	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	@Override
	public String toString() {
		return "JoueurDTO [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", login=" + login
				+ ", motdepasse=" + motDePasse + "]";
	}
	public Integer getNumeroPresentation() {
		return numeroPresentation;
	}
	public void setNumeroPresentation(Integer numeroPresentation) {
		this.numeroPresentation = numeroPresentation;
	}
	public Integer getPositionJeu() {
		return positionJeu;
	}
	public void setPositionJeu(Integer positionJeu) {
		this.positionJeu = positionJeu;
	}
	public Integer getResultatPremierLancer() {
		return resultatPremierLancer;
	}
	public void setResultatPremierLancer(Integer resultatPremierLancer) {
		this.resultatPremierLancer = resultatPremierLancer;
	}
	public Boolean isDoitJouer() {
		return doitJouer;
	}
	public void setDoitJouer(Boolean doitJouer) {
		this.doitJouer = doitJouer;
	}
	public Object getJoueurGauche() {
		return joueurGauche;
	}
	public void setJoueurGauche(Object joueurGauche) {
		this.joueurGauche = joueurGauche;
	}
	public Object getJoueurDroite() {
		return joueurDroite;
	}
	public void setJoueurDroite(Object joueurDroite) {
		this.joueurDroite = joueurDroite;
	}	
}