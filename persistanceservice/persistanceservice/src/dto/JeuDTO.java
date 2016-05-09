package dto;

import java.io.Serializable;

public class JeuDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Object partie;
	protected Object joueurs;
	
	public JeuDTO() {
		joueurs = new JoueursDTO();
	}

	public JeuDTO(Object partie, Object joueurs) {
		this.partie = partie;
		this.joueurs = joueurs;
	}

	public Object getPartie() {
		return partie;
	}

	public void setPartie(Object partie) {
		this.partie = partie;
	}

	public Object getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(Object joueurs) {
		this.joueurs = joueurs;
	}
}