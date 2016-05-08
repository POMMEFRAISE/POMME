package model;

import java.io.Serializable;

public class Jeu extends MessageErreur implements Serializable{

	private static final long serialVersionUID = 1514138537369034322L;
	private Joueurs joueurs;
	private Partie partie;
	
	public Jeu(){
		joueurs = new Joueurs();
	}
	
	public Partie getPartie() {
		return partie;
	}
	
	public void setPartie(Partie partie) {
		this.partie = partie;
	}

	public Joueurs getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(Joueurs joueurs) {
		this.joueurs = joueurs;
	}
}