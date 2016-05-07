package entites;

public class JeuEntite {

	protected PartieEntite partie;
	protected JoueursEntite joueurs;
	
	public JeuEntite(PartieEntite partie, JoueursEntite joueurs) {
		this.partie = partie;
		this.joueurs = joueurs;
	}

	public JeuEntite(){
		
	}
	
	public PartieEntite getPartie() {
		return partie;
	}

	public void setPartie(PartieEntite partie) {
		this.partie = partie;
	}

	public JoueursEntite getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(JoueursEntite joueurs) {
		this.joueurs = joueurs;
	}
}