package dto;

import java.io.Serializable;
import java.util.ArrayList;

public class JoueursDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4490660562143503832L;
	protected ArrayList<JoueurDTO> joueurs = new ArrayList<JoueurDTO>();
	
	public JoueursDTO(){
	}
	
	public void add(Object joueur){
		joueurs.add((JoueurDTO) joueur);
	}

	public ArrayList<JoueurDTO> getJoueurs (){
		return joueurs;
	}
}