package comportement.metier2presentation;

import comportement.Commande;
import comportement.commun.JoueurComportement;
import xml.metier2presentation.ReponseSeConnecter;

public class ReponseSeConnecterComportement implements Commande{

	private String pageRedirection = "";
	private ReponseSeConnecter reponseSeConnecter;
	private JoueurComportement joueurComportement;
	
	public ReponseSeConnecterComportement(ReponseSeConnecter reponseSeConnecter){
		this.reponseSeConnecter = reponseSeConnecter;
	}
	
	public void envoiMessage() {
		
	}

	public String reçoiMessage() {
		System.out.println("ReponseSeConnecterComportements");
		joueurComportement = new JoueurComportement();
		joueurComportement.setNom(reponseSeConnecter.getAuthentification().getJoueur().getNomJoueur());
		joueurComportement.setPrenom(reponseSeConnecter.getAuthentification().getJoueur().getPrenomJoueur());
		joueurComportement.setLogin(reponseSeConnecter.getAuthentification().getJoueur().getLoginJoueur());
		
		return verifierInformations();
	}
	
	public String verifierInformations(){
	   	if(joueurComportement.getNom().equals("") && joueurComportement.getPrenom().equals("")){
	   		pageRedirection = "connexion";
    	}else{
    		pageRedirection = "accueil";
    	}
	   	return pageRedirection;
	}
}