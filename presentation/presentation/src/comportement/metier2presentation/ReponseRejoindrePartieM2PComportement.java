package comportement.metier2presentation;

import comportement.Commande;
import model.Jeu;
import model.Partie;
import xml.metier2presentation.ReponseRejoindrePartieM2P;

public class ReponseRejoindrePartieM2PComportement implements Commande{
	private ReponseRejoindrePartieM2P reponseRejoindrePartie;
	private Jeu jeu;
	private String messageErreur;

	public ReponseRejoindrePartieM2PComportement(ReponseRejoindrePartieM2P reponseRejoindrePartie){
		this.reponseRejoindrePartie = reponseRejoindrePartie;
	}

	public Jeu reçoiMessage() {
		jeu = new Jeu();
		Partie partie = new Partie();
		partie.setNom(reponseRejoindrePartie.getJeu().getPartie().getNomPartie());
		jeu.setPartie(partie);
		messageErreur = reponseRejoindrePartie.getJeu().getMessageErreur();
		jeu.setMessage(messageErreur);
		return verifierInformations();
	}
	
	public Jeu verifierInformations(){
		if(messageErreur == null){
	   		jeu.setStatut(true);
    	}else{
	   		jeu.setStatut(false);
	   	}
		
		return jeu;
	}
}