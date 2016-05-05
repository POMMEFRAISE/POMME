package comportement.metier2presentation;

import comportement.Commande;
import model.MessageErreur;
import xml.metier2presentation.ReponseDemanderCreerPartieM2P;

public class ReponseDemanderCreerPartieM2PComportement implements Commande{
	private ReponseDemanderCreerPartieM2P reponseDemanderCreerPartieM2P;
	
	public ReponseDemanderCreerPartieM2PComportement(ReponseDemanderCreerPartieM2P reponseDemanderCreerPartieM2P){
		this.reponseDemanderCreerPartieM2P = reponseDemanderCreerPartieM2P;
	}

	public MessageErreur reçoiMessage() {
		MessageErreur messageErreur = new MessageErreur();
		if(reponseDemanderCreerPartieM2P.getCommande().isEnregistrer() == true){
			messageErreur.setStatut(true);			
		}else{
			messageErreur.setStatut(false);
		}
		return messageErreur;
	}

	public ReponseDemanderCreerPartieM2P getReponseDemanderCreerPartieM2P() {
		return reponseDemanderCreerPartieM2P;
	}

	public void setReponseDemanderCreerPartieM2P(ReponseDemanderCreerPartieM2P reponseDemanderCreerPartieM2P) {
		this.reponseDemanderCreerPartieM2P = reponseDemanderCreerPartieM2P;
	}
}