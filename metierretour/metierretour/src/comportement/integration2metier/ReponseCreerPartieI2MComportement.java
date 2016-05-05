package comportement.integration2metier;

import comportement.Commande;
import comportement.metier2presentation.ReponseCreerPartieM2PComportement;
import model.PartieMetierRetour;
import xml.integration2metier.ReponseCreerPartieI2M;

public class ReponseCreerPartieI2MComportement implements Commande{
	private ReponseCreerPartieI2M reponseCreerPartieI2M;

	public ReponseCreerPartieI2MComportement(ReponseCreerPartieI2M reponseCreerPartieI2M){
		this.reponseCreerPartieI2M = reponseCreerPartieI2M;
	}

	public void reçoiMessage() {
    	PartieMetierRetour partie = new PartieMetierRetour(
    			reponseCreerPartieI2M.getCreationPartie().getPartie().getNomPartie(),
    			reponseCreerPartieI2M.getCreationPartie().getPartie().getNbJoueurPartie()
    	);
    	
		ReponseCreerPartieM2PComportement reponseCreerPartieM2P = new ReponseCreerPartieM2PComportement(
				partie, 
				reponseCreerPartieI2M.getCreationPartie().getMessageErreur(),
				reponseCreerPartieI2M.getNumeroPresentation()
				);

		reponseCreerPartieM2P.envoiMessage();
	}

	public ReponseCreerPartieI2M getReponseCreerPartieI2M() {
		return reponseCreerPartieI2M;
	}

	public void setReponseCreerPartieI2M(ReponseCreerPartieI2M reponseCreerPartieI2M) {
		this.reponseCreerPartieI2M = reponseCreerPartieI2M;
	}
}