package comportement.metier2presentation;

import comportement.Commande;
import model.MessageErreur;
import xml.metier2presentation.ReponseDemanderRejoindrePartieM2P;

public class ReponseDemanderRejoindrePartieM2PComportement implements Commande{
	private ReponseDemanderRejoindrePartieM2P reponseDemanderRejoindrePartieM2P;
	
	public ReponseDemanderRejoindrePartieM2PComportement(ReponseDemanderRejoindrePartieM2P reponseDemanderRejoindrePartieM2P){
		this.reponseDemanderRejoindrePartieM2P = reponseDemanderRejoindrePartieM2P;
	}

	public MessageErreur reçoiMessage() {
		MessageErreur messageErreur = new MessageErreur();
		if(reponseDemanderRejoindrePartieM2P.getCommande().isEnregistrer() == true){
			messageErreur.setStatut(true);			
		}else{
			messageErreur.setStatut(false);
		}
		return messageErreur;
	}
}