package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Des implements Serializable{

	private static final long serialVersionUID = -3878162441569510889L;
	private ArrayList<De> des = new ArrayList<De>();
	private int taille;
	
	public Des(){
		this.setTaille(des.size());
	}
	
	public void add(De unDe){
		des.add(unDe);
		this.setTaille(des.size());
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public ArrayList<De> getDes (){
		return des;
	}
}