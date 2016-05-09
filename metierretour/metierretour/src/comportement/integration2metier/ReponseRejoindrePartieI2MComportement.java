package comportement.integration2metier;

import comportement.Commande;
import comportement.metier2presentation.ReponseRejoindrePartieM2PComportement;
import model.PartieMetierRetour;
import xml.integration2metier.PartieI2M;
import xml.integration2metier.ReponseRejoindrePartieI2M;

public class ReponseRejoindrePartieI2MComportement implements Commande{
	private ReponseRejoindrePartieI2M reponseRejoindrePartieI2M;

	public ReponseRejoindrePartieI2MComportement(ReponseRejoindrePartieI2M reponseRejoindrePartieI2M){
		this.reponseRejoindrePartieI2M = reponseRejoindrePartieI2M;
	}

	public void reçoiMessage() {
		PartieI2M unePartie = reponseRejoindrePartieI2M.getJeu().getPartie();
		PartieMetierRetour partie = new PartieMetierRetour();
		partie.setNomPartie(unePartie.getNomPartie());
		
		ReponseRejoindrePartieM2PComportement reponseRejoindrePartieM2P = new ReponseRejoindrePartieM2PComportement(
				partie,
				reponseRejoindrePartieI2M.getJeu().getMessageErreur(),
				reponseRejoindrePartieI2M.getNumeroPresentation()
				);

		reponseRejoindrePartieM2P.envoiMessage();
	}

	public ReponseRejoindrePartieI2M getReponseRejoindrePartieI2M() {
		return reponseRejoindrePartieI2M;
	}

	public void setReponseRejoindrePartieI2M(ReponseRejoindrePartieI2M reponseRejoindrePartieI2M) {
		this.reponseRejoindrePartieI2M = reponseRejoindrePartieI2M;
	}
}