package entites;

public class PartieEntite {
	
	protected int id;
	protected String nomPartie;
	protected int nbredejoueur;
	protected String statut;
	
	
	
	public PartieEntite(int id, String nomPartie) {
		this.id = id;
		this.nomPartie = nomPartie;
	}


	public PartieEntite() {
		this.id = 0;
		this.nomPartie = "";	
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


	@Override
	public String toString() {
		return "Partie [id=" + id + ", nomPartie=" + nomPartie + "]";
	}
	
	
	
	

}
