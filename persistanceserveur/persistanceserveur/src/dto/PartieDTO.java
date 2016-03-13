package dto;

import java.io.Serializable;

public class PartieDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int id;
	protected String nomPartie;
	protected int nbredejoueur;
	protected String statut;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomPartie() {
		return nomPartie;
	}
	public void setNomPartie(String nomPartie) {
		this.nomPartie = nomPartie;
	}
	public int getNbredejoueur() {
		return nbredejoueur;
	}
	public void setNbredejoueur(int nbredejoueur) {
		this.nbredejoueur = nbredejoueur;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	@Override
	public String toString() {
		return "PartieDTO [id=" + id + ", nomPartie=" + nomPartie + ", nbredejoueur=" + nbredejoueur + ", statut="
				+ statut + "]";
	}
	

}
