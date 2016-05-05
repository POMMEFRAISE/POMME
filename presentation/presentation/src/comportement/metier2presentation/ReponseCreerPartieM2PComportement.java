package comportement.metier2presentation;

import comportement.Commande;
import model.Partie;
import xml.metier2presentation.ReponseCreerPartieM2P;

public class ReponseCreerPartieM2PComportement implements Commande{
	private ReponseCreerPartieM2P reponseCreerPartie;
	private Partie partie;
	private String messageErreur;

	public ReponseCreerPartieM2PComportement(ReponseCreerPartieM2P reponseCreerPartie){
		this.reponseCreerPartie = reponseCreerPartie;
	}

	public Partie reçoiMessage() {
		partie = new Partie();
		partie.setNom(reponseCreerPartie.getCreationPartie().getPartie().getNomPartie());
		partie.setNbJoueurs(reponseCreerPartie.getCreationPartie().getPartie().getNbJoueurPartie());
		messageErreur = reponseCreerPartie.getCreationPartie().getMessageErreur();
		partie.setMessage(messageErreur);
		return verifierInformations();
	}
	
	public Partie verifierInformations(){
		if(messageErreur == null){
	   		partie.setStatut(true);
    	}else{
	   		partie.setStatut(false);
	   	}
		
		return partie;
	}
}