package model;

import java.io.Serializable;

public class JeuMetierRetour implements Serializable{
	private static final long serialVersionUID = 5481132462641667862L;
	private JoueursMetierRetour joueurs;
	private PartieMetierRetour partie;

	public JeuMetierRetour(PartieMetierRetour partie, JoueursMetierRetour joueurs){
		this.partie = partie;
		this.joueurs = joueurs;
	}
	
	public JeuMetierRetour(){
		joueurs = new JoueursMetierRetour();
	}

	public PartieMetierRetour getPartie() {
		return partie;
	}

	public void setPartie(PartieMetierRetour partie) {
		this.partie = partie;
	}

	public JoueursMetierRetour getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(JoueursMetierRetour joueurs) {
		this.joueurs = joueurs;
	}
}