package model;

import java.io.Serializable;
import java.util.ArrayList;

public class JoueursMetierRetour implements Serializable{

	private static final long serialVersionUID = -6548542034311618412L;

	private ArrayList<JoueurMetierRetour> joueurs = new ArrayList<JoueurMetierRetour>();
	private int taille;
	
	public JoueursMetierRetour(){
		this.setTaille(joueurs.size());
	}
	
	public void add(JoueurMetierRetour joueur){
		joueurs.add(joueur);
		this.setTaille(joueurs.size());
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public ArrayList<JoueurMetierRetour> getJoueurs (){
		return joueurs;
	}
}