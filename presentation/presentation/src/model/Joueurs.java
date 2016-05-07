package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Joueurs implements Serializable{

	private static final long serialVersionUID = -3878162441569510889L;
	private ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
	private int taille;
	
	public Joueurs(){
		this.setTaille(joueurs.size());
	}
	
	public void add(Joueur joueur){
		joueurs.add(joueur);
		this.setTaille(joueurs.size());
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public ArrayList<Joueur> getJoueurs (){
		return joueurs;
	}
}