package comportement.integration2metier;

import comportement.Commande;
import comportement.metier2presentation.ReponseDemanderCreerPartieM2PComportement;
import xml.integration2metier.ReponseDemanderCreerPartieI2M;

public class ReponseDemanderCreerPartieI2MComportement implements Commande{
	private ReponseDemanderCreerPartieI2M reponseDemanderCreerPartieI2M;
	
	public ReponseDemanderCreerPartieI2MComportement(ReponseDemanderCreerPartieI2M reponseDemanderCreerPartieI2M){
		this.reponseDemanderCreerPartieI2M = reponseDemanderCreerPartieI2M;
	}
	
	public void reçoiMessage() {
		ReponseDemanderCreerPartieM2PComportement reponseDemanderCreerPartieComportement = 
				new ReponseDemanderCreerPartieM2PComportement(
						reponseDemanderCreerPartieI2M.getCommande().isEnregistrer(),
						reponseDemanderCreerPartieI2M.getNumeroPresentation());
		reponseDemanderCreerPartieComportement.envoiMessage();	
	}

	public ReponseDemanderCreerPartieI2M getReponseDemanderCreerPartieI2M() {
		return reponseDemanderCreerPartieI2M;
	}

	public void setReponseDemanderCreerPartieI2M(ReponseDemanderCreerPartieI2M reponseDemanderCreerPartieI2M) {
		this.reponseDemanderCreerPartieI2M = reponseDemanderCreerPartieI2M;
	}
}