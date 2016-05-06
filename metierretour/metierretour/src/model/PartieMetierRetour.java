package model;

import java.io.Serializable;

public class PartieMetierRetour implements Serializable{
	private static final long serialVersionUID = 5948214634151906312L;
	private String nomPartie;
	private int nbJoueurPartie;
	
	public PartieMetierRetour(String nomPartie, int nbJoueurPartie){
		this.nomPartie = nomPartie;
		this.nbJoueurPartie = nbJoueurPartie;
	}
	
	public PartieMetierRetour(){

	}
	
	public String getNomPartie() {
		return nomPartie;
	}

	public void setNomPartie(String nomPartie) {
		this.nomPartie = nomPartie;
	}

	public int getNbJoueurPartie() {
		return nbJoueurPartie;
	}

	public void setNbJoueurPartie(int nbJoueurPartie) {
		this.nbJoueurPartie = nbJoueurPartie;
	}
}