package entites;

public class ScoreEntite {
	
	protected JoueurEntite idJoueur;
	protected PartieEntite idPartie;
	protected String resultat;
	
	
	public ScoreEntite() {
		this.idJoueur = null;
		this.idPartie = null;
		this.resultat = "";
	}
	
	public ScoreEntite(JoueurEntite idJoueur, PartieEntite idPartie, String resultat) {
		this.idJoueur = idJoueur;
		this.idPartie = idPartie;
		this.resultat = resultat;
	}
	
	
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
	
	
	

}
