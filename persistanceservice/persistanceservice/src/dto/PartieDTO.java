package dto;

import java.io.Serializable;
import java.sql.Date;

public class PartieDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int id;
	protected String nomPartie;
	protected Integer nbredejoueur;
	protected String statut;
	protected Date datedecreation;
	
	public PartieDTO(int id, String nomPartie, Integer nbredejoueur, String statut, Date datedecreation) {
		this.nomPartie = nomPartie;
		this.nbredejoueur = nbredejoueur;
		this.statut = statut;
		this.datedecreation = datedecreation;
	}
	
	public PartieDTO() {
		this.nomPartie = "";
		this.nbredejoueur = 0;
		this.statut = "";
		this.datedecreation = null;
	}
	
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
	public Integer getNbredejoueur() {
		return nbredejoueur;
	}
	public void setNbredejoueur(Integer nbredejoueur) {
		this.nbredejoueur = nbredejoueur;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public Date getDatedecreation() {
		return datedecreation;
	}
	public void setDatedecreation(Date datedecreation) {
		this.datedecreation = datedecreation;
	}
	@Override
	public String toString() {
		return "PartieDTO [id=" + id + ", nomPartie=" + nomPartie + ", nbredejoueur=" + nbredejoueur + ", statut="
				+ statut + "]";
	}
	

}
