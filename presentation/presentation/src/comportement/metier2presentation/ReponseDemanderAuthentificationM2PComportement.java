package comportement.metier2presentation;

import comportement.Commande;
import model.MessageErreur;
import xml.metier2presentation.ReponseDemanderAuthentificationM2P;

public class ReponseDemanderAuthentificationM2PComportement implements Commande{
	private ReponseDemanderAuthentificationM2P reponseDemanderAuthentificationM2P;
	
	public ReponseDemanderAuthentificationM2PComportement(ReponseDemanderAuthentificationM2P reponseDemanderAuthentificationM2P){
		this.reponseDemanderAuthentificationM2P = reponseDemanderAuthentificationM2P;
	}

	public MessageErreur reçoiMessage() {
		MessageErreur messageErreur = new MessageErreur();
		if(reponseDemanderAuthentificationM2P.getCommande().isEnregistrer() == true){
			messageErreur.setStatut(true);			
		}else{
			messageErreur.setStatut(false);
		}
		return messageErreur;
	}

	public ReponseDemanderAuthentificationM2P getReponseDemanderAuthentificationM2P() {
		return reponseDemanderAuthentificationM2P;
	}

	public void setReponseDemanderAuthentificationM2P(ReponseDemanderAuthentificationM2P reponseDemanderAuthentificationM2P) {
		this.reponseDemanderAuthentificationM2P = reponseDemanderAuthentificationM2P;
	}
}