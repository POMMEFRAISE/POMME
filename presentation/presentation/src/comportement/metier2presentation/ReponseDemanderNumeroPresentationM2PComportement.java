package comportement.metier2presentation;

import comportement.Commande;
import xml.metier2presentation.ReponseDemanderNumeroPresentationM2P;

public class ReponseDemanderNumeroPresentationM2PComportement implements Commande{
	private ReponseDemanderNumeroPresentationM2P reponseDemanderNumeroPresentationM2P;
	
	public ReponseDemanderNumeroPresentationM2PComportement(ReponseDemanderNumeroPresentationM2P reponseDemanderNumeroPresentationM2P){
		this.reponseDemanderNumeroPresentationM2P = reponseDemanderNumeroPresentationM2P;
	}

	public Integer reçoiMessage() {
		return reponseDemanderNumeroPresentationM2P.getNumeroPresentation();
	}

	public ReponseDemanderNumeroPresentationM2P getReponseDemanderNumeroPresentationM2P() {
		return reponseDemanderNumeroPresentationM2P;
	}

	public void setReponseDemanderNumeroPresentationM2P(ReponseDemanderNumeroPresentationM2P reponseDemanderNumeroPresentationM2P) {
		this.reponseDemanderNumeroPresentationM2P = reponseDemanderNumeroPresentationM2P;
	}
}