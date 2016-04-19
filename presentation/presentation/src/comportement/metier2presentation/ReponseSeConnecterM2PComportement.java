package comportement.metier2presentation;

import comportement.Commande;
import model.JoueurPresentation;
import xml.metier2presentation.ReponseSeConnecterM2P;

public class ReponseSeConnecterM2PComportement implements Commande{
	private ReponseSeConnecterM2P reponseSeConnecter;
	private JoueurPresentation joueurComportement;
	
	public ReponseSeConnecterM2PComportement(ReponseSeConnecterM2P reponseSeConnecter){
		this.reponseSeConnecter = reponseSeConnecter;
	}
	
	public void envoiMessage() {
		
	}

	public String reçoiMessage() {
		System.out.println("ReponseSeConnecterComportements");
		joueurComportement = new JoueurPresentation();
		joueurComportement.setNom(reponseSeConnecter.getAuthentification().getJoueur().getNomJoueur());
		joueurComportement.setPrenom(reponseSeConnecter.getAuthentification().getJoueur().getPrenomJoueur());
		joueurComportement.setLogin(reponseSeConnecter.getAuthentification().getJoueur().getLoginJoueur());
		
		return verifierInformations();
	}
	
	public String verifierInformations(){
	   	if(joueurComportement.getNom().equals("") && joueurComportement.getPrenom().equals("")){
	   		return "connexion";
    	}else{
    		return "accueil";
    	}
	}
}