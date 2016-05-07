package entites;

import java.util.ArrayList;

public class JoueursEntite{

	protected ArrayList<JoueurEntite> joueurs = new ArrayList<JoueurEntite>();
	
	public JoueursEntite(){
	}
	
	public void add(JoueurEntite joueur){
		joueurs.add(joueur);
	}

	public ArrayList<JoueurEntite> getJoueurs (){
		return joueurs;
	}
}