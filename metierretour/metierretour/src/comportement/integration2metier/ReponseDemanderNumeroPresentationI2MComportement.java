package comportement.integration2metier;

import comportement.Commande;
import comportement.metier2presentation.ReponseDemanderNumeroPresentationM2PComportement;
import xml.integration2metier.ReponseDemanderNumeroPresentationI2M;

public class ReponseDemanderNumeroPresentationI2MComportement implements Commande{
	private ReponseDemanderNumeroPresentationI2M reponseDemanderNumeroPresentationI2M;
	
	public ReponseDemanderNumeroPresentationI2MComportement(ReponseDemanderNumeroPresentationI2M reponseDemanderNumeroPresentationI2M){
		this.reponseDemanderNumeroPresentationI2M = reponseDemanderNumeroPresentationI2M;
	}
	
	public void reçoiMessage() {
		ReponseDemanderNumeroPresentationM2PComportement reponseDemanderNumeroPresentationComportement = new ReponseDemanderNumeroPresentationM2PComportement(reponseDemanderNumeroPresentationI2M.getNumeroPresentation());
		reponseDemanderNumeroPresentationComportement.envoiMessage();	
	}

	public ReponseDemanderNumeroPresentationI2M getReponseDemanderNumeroPresentationI2M() {
		return reponseDemanderNumeroPresentationI2M;
	}

	public void setReponseDemanderNumeroPresentationI2M(ReponseDemanderNumeroPresentationI2M reponseDemanderNumeroPresentationI2M) {
		this.reponseDemanderNumeroPresentationI2M = reponseDemanderNumeroPresentationI2M;
	}
}