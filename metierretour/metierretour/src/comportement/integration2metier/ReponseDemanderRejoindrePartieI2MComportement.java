package comportement.integration2metier;

import comportement.Commande;
import comportement.metier2presentation.ReponseDemanderRejoindrePartieM2PComportement;
import xml.integration2metier.ReponseDemanderRejoindrePartieI2M;

public class ReponseDemanderRejoindrePartieI2MComportement implements Commande{
	private ReponseDemanderRejoindrePartieI2M reponseDemanderRejoindrePartieI2M;
	
	public ReponseDemanderRejoindrePartieI2MComportement(ReponseDemanderRejoindrePartieI2M reponseDemanderRejoindrePartieI2M){
		this.reponseDemanderRejoindrePartieI2M = reponseDemanderRejoindrePartieI2M;
	}
	
	public void reçoiMessage() {
		ReponseDemanderRejoindrePartieM2PComportement reponseDemanderRejoindrePartieComportement = 
				new ReponseDemanderRejoindrePartieM2PComportement(
						reponseDemanderRejoindrePartieI2M.getCommande().isEnregistrer(),
						reponseDemanderRejoindrePartieI2M.getNumeroPresentation());
		reponseDemanderRejoindrePartieComportement.envoiMessage();	
	}
}