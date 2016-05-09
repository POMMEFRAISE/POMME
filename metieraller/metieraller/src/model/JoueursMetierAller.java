package model;

import java.io.Serializable;
import java.util.ArrayList;

public class JoueursMetierAller implements Serializable{

	private static final long serialVersionUID = -6548542034311618412L;

	private ArrayList<JoueurMetierAller> joueurs = new ArrayList<JoueurMetierAller>();
	private int taille;
	
	public JoueursMetierAller(){
		this.setTaille(joueurs.size());
	}
	
	public void add(JoueurMetierAller joueur){
		joueurs.add(joueur);
		this.setTaille(joueurs.size());
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public ArrayList<JoueurMetierAller> getJoueurs (){
		return joueurs;
	}
}