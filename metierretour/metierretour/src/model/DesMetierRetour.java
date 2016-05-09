package model;

import java.io.Serializable;
import java.util.ArrayList;

public class DesMetierRetour implements Serializable{

	private static final long serialVersionUID = 2834460926236627290L;
	private ArrayList<DeMetierRetour> des = new ArrayList<DeMetierRetour>();
	private int taille;
	
	public DesMetierRetour(){
		this.setTaille(des.size());
	}
	
	public void add(DeMetierRetour de){
		des.add(de);
		this.setTaille(des.size());
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public ArrayList<DeMetierRetour> getDes (){
		return des;
	}
}