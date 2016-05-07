package model;

import java.io.Serializable;

public class JoueurMetierAller implements Serializable{
	private static final long serialVersionUID = 5948214634151906312L;
	private String loginJoueur;
	
	public JoueurMetierAller(String loginJoueur){
		this.loginJoueur = loginJoueur;
	}
	
	public JoueurMetierAller(){
		
	}
	
	public String getLoginJoueur() {
		return loginJoueur;
	}
	
	public void setLoginJoueur(String loginJoueur) {
		this.loginJoueur = loginJoueur;
	}
}