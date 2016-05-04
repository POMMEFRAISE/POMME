package comportement.metier2presentation;

import comportement.Commande;
import model.Joueur;
import model.MessageErreur;
import xml.metier2presentation.ReponseSeConnecterM2P;

public class ReponseSeConnecterM2PComportement implements Commande{
	private ReponseSeConnecterM2P reponseSeConnecter;
	private Joueur joueur;
	private String messageErreur;

	public ReponseSeConnecterM2PComportement(ReponseSeConnecterM2P reponseSeConnecter){
		this.reponseSeConnecter = reponseSeConnecter;
	}

	public String reçoiMessage() {
		System.out.println("ReponseSeConnecterComportements");
		joueur = new Joueur();
		joueur.setNom(reponseSeConnecter.getAuthentification().getJoueur().getNomJoueur());
		joueur.setPrenom(reponseSeConnecter.getAuthentification().getJoueur().getPrenomJoueur());
		joueur.setLogin(reponseSeConnecter.getAuthentification().getJoueur().getLoginJoueur());
		
		messageErreur = reponseSeConnecter.getAuthentification().getMessageErreur();
		System.out.println("Message Erreur présentation : "+messageErreur);
		return verifierInformations();
	}
	
	public String verifierInformations(){
		MessageErreur messageErr = new MessageErreur();
		String redirection;
		if(messageErreur == null){
	   		redirection = "accueil";
    	}else{
	   		messageErr.setMessage(messageErreur);
    		redirection = "connexion";
    	}
		
		return redirection;
	}
}