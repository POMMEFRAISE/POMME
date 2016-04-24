package comportement.metier2presentation;

import comportement.Commande;
import model.JoueurPresentation;
import xml.metier2presentation.ReponseSeConnecterM2P;

public class ReponseSeConnecterM2PComportement implements Commande{
	private ReponseSeConnecterM2P reponseSeConnecter;
	private JoueurPresentation joueurPresentation;
	private String messageErreur;
	
	public ReponseSeConnecterM2PComportement(ReponseSeConnecterM2P reponseSeConnecter){
		this.reponseSeConnecter = reponseSeConnecter;
	}
	
	public void envoiMessage() {
		
	}

	public String reçoiMessage() {
		System.out.println("ReponseSeConnecterComportements");
		joueurPresentation = new JoueurPresentation();
		joueurPresentation.setNom(reponseSeConnecter.getAuthentification().getJoueur().getNomJoueur());
		joueurPresentation.setPrenom(reponseSeConnecter.getAuthentification().getJoueur().getPrenomJoueur());
		joueurPresentation.setLogin(reponseSeConnecter.getAuthentification().getJoueur().getLoginJoueur());
		
		messageErreur = reponseSeConnecter.getAuthentification().getMessageErreur();
		System.out.println("Message Erreur présentation : "+messageErreur);
		return verifierInformations();
	}
	
	public String verifierInformations(){
	   	if(messageErreur.equals("")){
	   		return "accueil";
    	}else{
    		return "connexion";
    	}
	}
}