package comportement.presentation2metier;

import comportement.Commande;
import comportement.metier2integration.RejoindrePartieM2IComportement;
import model.JoueurMetierAller;
import model.PartieMetierAller;
import xml.presentation2metier.RejoindrePartieP2M;

public class RejoindrePartieP2MComportement implements Commande{
	private RejoindrePartieP2M rejoindrePartieP2M;
	
	public RejoindrePartieP2MComportement(RejoindrePartieP2M rejoindrePartieP2M){
		this.rejoindrePartieP2M = rejoindrePartieP2M;
	}
	
	public void reçoiMessage() {
		JoueurMetierAller joueur = new JoueurMetierAller();
		joueur.setLoginJoueur(rejoindrePartieP2M.getRejoindreUnePartie().getJoueur().getLoginJoueur());

		PartieMetierAller partie = new PartieMetierAller();
		partie.setNomPartie(rejoindrePartieP2M.getRejoindreUnePartie().getPartie().getNomPartie());
		
		RejoindrePartieM2IComportement rejoindrePartieM2I = new RejoindrePartieM2IComportement(
				joueur,
				partie,
				rejoindrePartieP2M.getNumeroPresentation()
		);
		rejoindrePartieM2I.envoiMessage();
	}

	public RejoindrePartieP2M getRejoindrePartieP2M() {
		return rejoindrePartieP2M;
	}

	public void setRejoindrePartieP2M(RejoindrePartieP2M rejoindrePartieP2M) {
		this.rejoindrePartieP2M = rejoindrePartieP2M;
	}
}