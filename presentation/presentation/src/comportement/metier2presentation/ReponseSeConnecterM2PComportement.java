package comportement.metier2presentation;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import comportement.Commande;
import model.JoueurPresentation;
import model.MonEvent;
import model.Redirection;
import xml.metier2presentation.ReponseSeConnecterM2P;

public class ReponseSeConnecterM2PComportement implements Commande{
	private ReponseSeConnecterM2P reponseSeConnecter;
	private JoueurPresentation joueurPresentation;
	private String messageErreur;
	@Inject
	Event<MonEvent> monEventEmetteur;	
	public ReponseSeConnecterM2PComportement(ReponseSeConnecterM2P reponseSeConnecter){
		this.reponseSeConnecter = reponseSeConnecter;
	}
	
	public void envoiMessage() {
		
	}

	public void reçoiMessage() {
		System.out.println("ReponseSeConnecterComportements");
		joueurPresentation = new JoueurPresentation();
		joueurPresentation.setNom(reponseSeConnecter.getAuthentification().getJoueur().getNomJoueur());
		joueurPresentation.setPrenom(reponseSeConnecter.getAuthentification().getJoueur().getPrenomJoueur());
		joueurPresentation.setLogin(reponseSeConnecter.getAuthentification().getJoueur().getLoginJoueur());
		
		messageErreur = reponseSeConnecter.getAuthentification().getMessageErreur();
		System.out.println("Message Erreur présentation : "+messageErreur);
		verifierInformations();
	}
	
	public void verifierInformations(){
		Redirection redirection = new Redirection();
		MonEvent event = new MonEvent();

		if(messageErreur.equals("")){
	   		redirection.setRedirection("accueil");
			event.setRedirection(redirection);
			event.setJoueurPresentation(joueurPresentation);
    	}else{
	   		redirection.setMessage(messageErreur);
    		redirection.setRedirection("connexion");
    		event.setRedirection(redirection);
    	}
		monEventEmetteur.fire(event);
	}
}