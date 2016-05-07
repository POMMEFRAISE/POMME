package model;

import java.io.Serializable;
import java.util.ArrayList;

public class JeuxMetierRetour implements Serializable{

	private static final long serialVersionUID = 5068397022677049755L;
	private ArrayList<JeuMetierRetour> jeux = new ArrayList<JeuMetierRetour>();
	private int taille;
	
	public JeuxMetierRetour(){
		this.setTaille(jeux.size());
	}
	
	public void add(JeuMetierRetour jeu){
		jeux.add(jeu);
		this.setTaille(jeux.size());
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public ArrayList<JeuMetierRetour> getJeux (){
		return jeux;
	}
}