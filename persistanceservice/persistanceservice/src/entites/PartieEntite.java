package entites;

import java.sql.Date;

public class PartieEntite {
	
	protected int id;
	protected String nomPartie;
	protected int nbredejoueur;
	protected String statut;
	protected Date datedecreation;
	
	
	
	public PartieEntite(int id, String nomPartie, Date datedecreation) {
		this.id = id;
		this.nomPartie = nomPartie;
		this.datedecreation = datedecreation;
	}


	public PartieEntite() {
		this.id = 0;
		this.nomPartie = "";
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


	public Date getDatedecreation() {
		return datedecreation;
	}


	public void setDatedecreation(Date datedecreation) {
		this.datedecreation = datedecreation;
	}
	
	@Override
	public String toString() {
		return "Partie [id=" + id + ", nomPartie=" + nomPartie + ", datedecreation=" + datedecreation + "]";
	}
	

}
