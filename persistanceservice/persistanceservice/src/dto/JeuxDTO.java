package dto;

import java.io.Serializable;
import java.util.ArrayList;

public class JeuxDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected ArrayList<JeuDTO> jeux = new ArrayList<JeuDTO>();
	
	public JeuxDTO(){
	}
	
	public void add(JeuDTO jeu){
		jeux.add(jeu);
	}

	public ArrayList<JeuDTO> getJeux (){
		return jeux;
	}
}