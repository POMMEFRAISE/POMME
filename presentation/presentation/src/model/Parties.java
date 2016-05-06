package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Parties extends MessageErreur implements Serializable{

	private static final long serialVersionUID = -6548542034311618412L;

	private ArrayList<Partie> parties = new ArrayList<Partie>();
	private int taille;
	
	public Parties(){
		this.setTaille(parties.size());
	}
	
	public void add(Partie partie){
		parties.add(partie);
		this.setTaille(parties.size());
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public ArrayList<Partie> getParties (){
		return parties;
	}
}