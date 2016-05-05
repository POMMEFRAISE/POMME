package comportement.metier2presentation;

import comportement.Commande;
import model.Joueur;
import xml.metier2presentation.ReponseSeConnecterM2P;

public class ReponseSeConnecterM2PComportement implements Commande{
	private ReponseSeConnecterM2P reponseSeConnecter;
	private Joueur joueur;
	private String messageErreur;

	public ReponseSeConnecterM2PComportement(ReponseSeConnecterM2P reponseSeConnecter){
		this.reponseSeConnecter = reponseSeConnecter;
	}

	public Joueur reçoiMessage() {
		joueur = new Joueur();
		joueur.setNom(reponseSeConnecter.getAuthentification().getJoueur().getNomJoueur());
		joueur.setPrenom(reponseSeConnecter.getAuthentification().getJoueur().getPrenomJoueur());
		joueur.setLogin(reponseSeConnecter.getAuthentification().getJoueur().getLoginJoueur());
		messageErreur = reponseSeConnecter.getAuthentification().getMessageErreur();
		joueur.setMessage(messageErreur);
		System.out.println("Message Erreur présentation : "+messageErreur);
		return verifierInformations();
	}
	
	public Joueur verifierInformations(){
		if(messageErreur == null){
	   		joueur.setStatut(true);
    	}else{
	   		joueur.setStatut(false);
	   	}
		
		return joueur;
	}
}