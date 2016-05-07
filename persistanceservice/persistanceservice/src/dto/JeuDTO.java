package dto;

import java.io.Serializable;

public class JeuDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected PartieDTO partie;
	protected JoueursDTO joueurs;
	
	public JeuDTO() {

	}

	public JeuDTO(PartieDTO partie, JoueursDTO joueurs) {
		this.partie = partie;
		this.joueurs = joueurs;
	}

	public PartieDTO getPartie() {
		return partie;
	}

	public void setPartie(PartieDTO partie) {
		this.partie = partie;
	}

	public JoueursDTO getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(JoueursDTO joueurs) {
		this.joueurs = joueurs;
	}
}