package comportement.presentation2metier;

import activeMQ.Producteur;
import model.Joueur;
import model.Partie;
import xml.presentation2metier.JoueurP2M;
import xml.presentation2metier.ObjectFactory;
import xml.presentation2metier.PartieP2M;
import xml.presentation2metier.RejoindrePartieP2M;
import xml.presentation2metier.RejoindreUnePartieP2M;

public class RejoindrePartieP2MComportement{
	private Joueur joueur;
	private Partie partie;
	private int numeroPresentation;
	
	public RejoindrePartieP2MComportement(Joueur joueur, Partie partie, int numeroPresentation){
		this.joueur = joueur;
		this.partie = partie;
		this.numeroPresentation = numeroPresentation;
	}

	public void envoiMessage() {
		ObjectFactory objFactory = new ObjectFactory();
		PartieP2M unePartie = objFactory.createPartieP2M();
		unePartie.setNomPartie(partie.getNom());
		JoueurP2M unJoueur = objFactory.createJoueurP2M();
		unJoueur.setLoginJoueur(joueur.getLogin());
		RejoindreUnePartieP2M rejoindreUnePartie = objFactory.createRejoindreUnePartieP2M();
		rejoindreUnePartie.setJoueur(unJoueur);
		rejoindreUnePartie.setPartie(unePartie);
		RejoindrePartieP2M rejoindrePartie = objFactory.createRejoindrePartieP2M();
		rejoindrePartie.setNumeroPresentation(numeroPresentation);
		rejoindrePartie.setRejoindreUnePartie(rejoindreUnePartie);
		new Producteur(rejoindrePartie);	
	}

	public int getNumeroPresentation() {
		return numeroPresentation;
	}

	public void setNumeroPresentation(int numeroPresentation) {
		this.numeroPresentation = numeroPresentation;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}
}