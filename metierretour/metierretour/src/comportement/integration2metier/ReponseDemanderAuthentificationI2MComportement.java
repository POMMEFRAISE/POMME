package comportement.integration2metier;

import comportement.Commande;
import comportement.metier2presentation.ReponseDemanderAuthentificationM2PComportement;
import xml.integration2metier.ReponseDemanderAuthentificationI2M;

public class ReponseDemanderAuthentificationI2MComportement implements Commande{
	private ReponseDemanderAuthentificationI2M reponseDemanderAuthentificationI2M;
	
	public ReponseDemanderAuthentificationI2MComportement(ReponseDemanderAuthentificationI2M reponseDemanderAuthentificationI2M){
		this.reponseDemanderAuthentificationI2M = reponseDemanderAuthentificationI2M;
	}
	
	public void reçoiMessage() {
		ReponseDemanderAuthentificationM2PComportement reponseDemanderAuthentificationComportement = new ReponseDemanderAuthentificationM2PComportement();
		reponseDemanderAuthentificationComportement.envoiMessage();	
	}

	public void envoiMessage() {
		
	}

	public ReponseDemanderAuthentificationI2M getReponseDemanderAuthentificationI2M() {
		return reponseDemanderAuthentificationI2M;
	}

	public void setReponseDemanderAuthentificationI2M(ReponseDemanderAuthentificationI2M reponseDemanderAuthentificationI2M) {
		this.reponseDemanderAuthentificationI2M = reponseDemanderAuthentificationI2M;
	}
}