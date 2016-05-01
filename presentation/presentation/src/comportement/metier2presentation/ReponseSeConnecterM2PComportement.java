package comportement.metier2presentation;

import comportement.Commande;
import model.JoueurPresentation;
import model.Redirection;
import xml.metier2presentation.ReponseSeConnecterM2P;

public class ReponseSeConnecterM2PComportement implements Commande{
	private ReponseSeConnecterM2P reponseSeConnecter;
	private JoueurPresentation joueurPresentation;
	private String messageErreur;

	public ReponseSeConnecterM2PComportement(ReponseSeConnecterM2P reponseSeConnecter){
		this.reponseSeConnecter = reponseSeConnecter;
	}

	public Redirection reçoiMessage() {
		System.out.println("ReponseSeConnecterComportements");
		joueurPresentation = new JoueurPresentation();
		joueurPresentation.setNom(reponseSeConnecter.getAuthentification().getJoueur().getNomJoueur());
		joueurPresentation.setPrenom(reponseSeConnecter.getAuthentification().getJoueur().getPrenomJoueur());
		joueurPresentation.setLogin(reponseSeConnecter.getAuthentification().getJoueur().getLoginJoueur());
		
		messageErreur = reponseSeConnecter.getAuthentification().getMessageErreur();
		System.out.println("Message Erreur présentation : "+messageErreur);
		return verifierInformations();
	}
	
	public Redirection verifierInformations(){
		Redirection redirection = new Redirection();

		if(messageErreur.equals("")){
	   		redirection.setRedirection("accueil");
    	}else{
	   		redirection.setMessage(messageErreur);
    		redirection.setRedirection("connexion");
    	}
		
		return redirection;
	}
}