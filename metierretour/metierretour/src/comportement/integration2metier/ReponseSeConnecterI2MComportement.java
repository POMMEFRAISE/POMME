package comportement.integration2metier;

import comportement.Commande;
import comportement.metier2presentation.ReponseSeConnecterM2PComportement;
import model.JoueurMetierRetour;
import xml.integration2metier.ReponseSeConnecterI2M;

public class ReponseSeConnecterI2MComportement implements Commande{
	private ReponseSeConnecterI2M reponseSeConnecterI2M;

	public ReponseSeConnecterI2MComportement(ReponseSeConnecterI2M reponseSeConnecterI2M){
		this.reponseSeConnecterI2M = reponseSeConnecterI2M;
	}
	
	public ReponseSeConnecterI2M getReponseSeConnecterI2M() {
		return reponseSeConnecterI2M;
	}

	public void setReponseSeConnecterI2M(ReponseSeConnecterI2M reponseSeConnecterI2M) {
		this.reponseSeConnecterI2M = reponseSeConnecterI2M;
	}

	public void reçoiMessage() {
    	JoueurMetierRetour joueur = new JoueurMetierRetour(
    			reponseSeConnecterI2M.getAuthentification().getJoueur().getNomJoueur(),
    			reponseSeConnecterI2M.getAuthentification().getJoueur().getPrenomJoueur(),
    			reponseSeConnecterI2M.getAuthentification().getJoueur().getLoginJoueur()
    	);
    	
		ReponseSeConnecterM2PComportement reponseSeConnecterM2P = new ReponseSeConnecterM2PComportement(
				joueur, 
				reponseSeConnecterI2M.getAuthentification().getMessageErreur(),
    			reponseSeConnecterI2M.getNumeroPresentation()
				);

		reponseSeConnecterM2P.envoiMessage();
	}
}