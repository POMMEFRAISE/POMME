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
	
	
}