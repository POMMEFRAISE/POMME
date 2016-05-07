package comportement.metier2integration;

import activeMQ.Producteur;
import model.JoueurMetierAller;
import model.PartieMetierAller;
import xml.metier2integration.JoueurM2I;
import xml.metier2integration.ObjectFactory;
import xml.metier2integration.PartieM2I;
import xml.metier2integration.RejoindrePartieM2I;
import xml.metier2integration.RejoindreUnePartieM2I;

public class RejoindrePartieM2IComportement{
	private JoueurMetierAller joueur;
	private PartieMetierAller partie;
	private int numeroPresentation;
	
	public RejoindrePartieM2IComportement(JoueurMetierAller joueur, PartieMetierAller partie, int numeroPresentation){
		this.joueur = joueur;
		this.partie = partie;
		this.numeroPresentation = numeroPresentation;
	}
	
	public void envoiMessage() {
		ObjectFactory objFactory = new ObjectFactory();
		PartieM2I unePartie = objFactory.createPartieM2I();
		unePartie.setNomPartie(partie.getNomPartie());
		JoueurM2I unJoueur = objFactory.createJoueurM2I();
		unJoueur.setLoginJoueur(joueur.getLoginJoueur());
		RejoindreUnePartieM2I rejoindreUnePartie = objFactory.createRejoindreUnePartieM2I();
		rejoindreUnePartie.setJoueur(unJoueur);
		rejoindreUnePartie.setPartie(unePartie);
		RejoindrePartieM2I rejoindrePartieM2I = objFactory.createRejoindrePartieM2I();
		rejoindrePartieM2I.setNumeroPresentation(numeroPresentation);
		
		new Producteur(rejoindrePartieM2I);
	}

	public int getNumeroPresentation() {
		return numeroPresentation;
	}

	public void setNumeroPresentation(int numeroPresentation) {
		this.numeroPresentation = numeroPresentation;
	}

	public PartieMetierAller getPartie() {
		return partie;
	}

	public void setPartie(PartieMetierAller partie) {
		this.partie = partie;
	}

	public JoueurMetierAller getJoueur() {
		return joueur;
	}

	public void setJoueur(JoueurMetierAller joueur) {
		this.joueur = joueur;
	}
}