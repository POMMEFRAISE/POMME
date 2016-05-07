package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Jeu extends MessageErreur implements Serializable{

	private static final long serialVersionUID = 1514138537369034322L;
	private List<Joueur> joueurs;
	private Partie partie;
	
	public Jeu(){
		joueurs = new ArrayList<Joueur>();
	}
	
	public Partie getPartie() {
		return partie;
	}
	
	public void setPartie(Partie partie) {
		this.partie = partie;
	}

	public List<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}
}