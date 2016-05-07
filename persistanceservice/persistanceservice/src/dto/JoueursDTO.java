package dto;

import java.io.Serializable;
import java.util.ArrayList;

public class JoueursDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected ArrayList<JoueurDTO> joueurs = new ArrayList<JoueurDTO>();
	
	public JoueursDTO(){
	}
	
	public void add(JoueurDTO joueur){
		joueurs.add(joueur);
	}

	public ArrayList<JoueurDTO> getJoueurs (){
		return joueurs;
	}
}