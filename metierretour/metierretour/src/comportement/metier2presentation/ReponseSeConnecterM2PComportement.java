package comportement.metier2presentation;

import activeMQ.Producteur;
import comportement.Commande;
import model.JoueurMetierRetour;
import xml.metier2presentation.AuthentificationM2P;
import xml.metier2presentation.JoueurM2P;
import xml.metier2presentation.ObjectFactory;
import xml.metier2presentation.ReponseSeConnecterM2P;

public class ReponseSeConnecterM2PComportement implements Commande{
	private JoueurMetierRetour joueurMetier;
	private String messageErreur;
	
	public ReponseSeConnecterM2PComportement(JoueurMetierRetour joueurMetier, String messageErreur){
		this.joueurMetier = joueurMetier;
		this.messageErreur = messageErreur;
	}
	
	public void reçoiMessage() {
		
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
		
		new Producteur(reponseSeConencter);
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
}