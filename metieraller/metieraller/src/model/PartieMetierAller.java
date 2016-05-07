package model;

import java.io.Serializable;

public class PartieMetierAller implements Serializable{
	private static final long serialVersionUID = 5948214634151906312L;
	private String nomPartie;
	
	public PartieMetierAller(String nomPartie, int nbJoueurPartie){
		this.nomPartie = nomPartie;
	}
	
	public PartieMetierAller(){

	}
	
	public String getNomPartie() {
		return nomPartie;
	}

	public void setNomPartie(String nomPartie) {
		this.nomPartie = nomPartie;
	}
}