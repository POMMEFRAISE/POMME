package dto;

import java.io.Serializable;

import entites.JoueurEntite;
import entites.PartieEntite;

public class ScoreDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JoueurEntite idJoueur;
	protected PartieEntite idPartie;
	protected String resultat;
	
	
	public JoueurEntite getIdJoueur() {
		return idJoueur;
	}
	public void setIdJoueur(JoueurEntite idJoueur) {
		this.idJoueur = idJoueur;
	}
	public PartieEntite getIdPartie() {
		return idPartie;
	}
	public void setIdPartie(PartieEntite idPartie) {
		this.idPartie = idPartie;
	}
	public String getResultat() {
		return resultat;
	}
	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
	@Override
	public String toString() {
		return "ScoreDTO [idJoueur=" + idJoueur + ", idPartie=" + idPartie + ", resultat=" + resultat + "]";
	}
	
	

}
