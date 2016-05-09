package model;

import java.io.Serializable;

public class JeuMetierAller implements Serializable{
	private static final long serialVersionUID = 5481132462641667862L;
	private JoueursMetierAller joueurs;
	private PartieMetierAller partie;

	public JeuMetierAller(PartieMetierAller partie, JoueursMetierAller joueurs){
		this.partie = partie;
		this.joueurs = joueurs;
	}
	
	public JeuMetierAller(){
		joueurs = new JoueursMetierAller();
	}

	public PartieMetierAller getPartie() {
		return partie;
	}

	public void setPartie(PartieMetierAller partie) {
		this.partie = partie;
	}

	public JoueursMetierAller getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(JoueursMetierAller joueurs) {
		this.joueurs = joueurs;
	}
}