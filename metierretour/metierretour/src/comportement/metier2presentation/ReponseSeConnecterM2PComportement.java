package comportement.metier2presentation;

import activeMQ.Producteur;
import model.JoueurMetierRetour;
import xml.metier2presentation.AuthentificationM2P;
import xml.metier2presentation.JoueurM2P;
import xml.metier2presentation.ObjectFactory;
import xml.metier2presentation.ReponseSeConnecterM2P;

public class ReponseSeConnecterM2PComportement{
	private JoueurMetierRetour joueurMetier;
	private String messageErreur;
	private int numeroPresentation;
	
	public ReponseSeConnecterM2PComportement(JoueurMetierRetour joueurMetier, String messageErreur, int numeroPresentation){
		this.joueurMetier = joueurMetier;
		this.messageErreur = messageErreur;
		this.numeroPresentation = numeroPresentation;
	}
	
	public void envoiMessage() {
		ObjectFactory objFactory = new ObjectFactory();
		JoueurM2P joueur = objFactory.createJoueurM2P();
		joueur.setLoginJoueur(joueurMetier.getLoginJoueur());
		joueur.setNomJoueur(joueurMetier.getNomJoueur());
		joueur.setPrenomJoueur(joueurMetier.getPrenomJoueur());
		AuthentificationM2P authentification = objFactory.createAuthentificationM2P();
		authentification.setJoueur(joueur);
		authentification.setMessageErreur(messageErreur);
		ReponseSeConnecterM2P reponseSeConencter = objFactory.createReponseSeConnecterM2P();
		reponseSeConencter.setAuthentification(authentification);
		
		Thread thread = new Thread(new Producteur(reponseSeConencter, numeroPresentation));
		thread.start();
	}

	public String getMessageErreur() {
		return messageErreur;
	}

	public void setMessageErreur(String messageErreur) {
		this.messageErreur = messageErreur;
	}

	public JoueurMetierRetour getJoueurMetier() {
		return joueurMetier;
	}

	public void setJoueur(JoueurMetierRetour joueurMetier) {
		this.joueurMetier = joueurMetier;
	}

	public int getNumeroPresentation() {
		return numeroPresentation;
	}

	public void setNumeroPresentation(int numeroPresentation) {
		this.numeroPresentation = numeroPresentation;
	}
}