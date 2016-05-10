package model;

import java.io.Serializable;

public class Joueur extends MessageErreur implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 4010663271871955893L;
	private String login;
    private String nom;
    private String prenom;
    private String mdp;
    private Joueur joueurGauche;
    private Joueur joueurDroite;
    private int positionJeu;
    private int resultatPremierLancer;
    private boolean doitJouer;
    private int numeroPresentation;
    private boolean premier;
    
    public Joueur(){
    	
    }
    
    public Joueur(String login){
        this.login=login;
    }
    
    public String getLogin(){
        return login;
    }
    
    public void setLogin(String login){
        this.login=login;
    }

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Joueur getJoueurGauche() {
		return joueurGauche;
	}

	public void setJoueurGauche(Joueur joueurGauche) {
		this.joueurGauche = joueurGauche;
	}

	public Joueur getJoueurDroite() {
		return joueurDroite;
	}

	public void setJoueurDroite(Joueur joueurDroite) {
		this.joueurDroite = joueurDroite;
	}

	public int getPositionJeu() {
		return positionJeu;
	}

	public void setPositionJeu(int positionJeu) {
		this.positionJeu = positionJeu;
	}

	public int getResultatPremierLancer() {
		return resultatPremierLancer;
	}

	public void setResultatPremierLancer(int resultatPremierLancer) {
		this.resultatPremierLancer = resultatPremierLancer;
	}

	public boolean isDoitJouer() {
		return doitJouer;
	}

	public void setDoitJouer(boolean doitJouer) {
		this.doitJouer = doitJouer;
	}

	public int getNumeroPresentation() {
		return numeroPresentation;
	}

	public void setNumeroPresentation(int numeroPresentation) {
		this.numeroPresentation = numeroPresentation;
	}

	public boolean isPremier() {
		return premier;
	}

	public void setPremier(boolean premier) {
		this.premier = premier;
	}
	
	
}