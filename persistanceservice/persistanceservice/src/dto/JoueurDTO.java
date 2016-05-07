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
	protected int numeroPresentation;
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
	public int getNumeroPresentation() {
		return numeroPresentation;
	}
	public void setNumeroPresentation(int numeroPresentation) {
		this.numeroPresentation = numeroPresentation;
	}
	
	
}
