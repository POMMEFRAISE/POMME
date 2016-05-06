package model;

import java.io.Serializable;
import java.util.ArrayList;

public class PartiesMetierRetour implements Serializable{

	private static final long serialVersionUID = -6548542034311618412L;

	private ArrayList<PartieMetierRetour> parties = new ArrayList<PartieMetierRetour>();
	private int taille;
	
	public PartiesMetierRetour(){
		this.setTaille(parties.size());
	}
	
	public void add(PartieMetierRetour partie){
		parties.add(partie);
		this.setTaille(parties.size());
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public ArrayList<PartieMetierRetour> getParties (){
		return parties;
	}
}