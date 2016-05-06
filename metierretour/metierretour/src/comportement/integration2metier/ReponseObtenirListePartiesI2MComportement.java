package comportement.integration2metier;

import comportement.Commande;
import comportement.metier2presentation.ReponseObtenirListePartiesM2PComportement;
import model.PartieMetierRetour;
import model.PartiesMetierRetour;
import xml.integration2metier.PartieI2M;
import xml.integration2metier.ReponseObtenirListePartiesI2M;

public class ReponseObtenirListePartiesI2MComportement implements Commande{
	private ReponseObtenirListePartiesI2M reponseObtenirListePartiesI2M;

	public ReponseObtenirListePartiesI2MComportement(ReponseObtenirListePartiesI2M reponseObtenirListePartiesI2M){
		this.reponseObtenirListePartiesI2M = reponseObtenirListePartiesI2M;
	}

	public void reçoiMessage() {
		PartiesMetierRetour listeParties = new PartiesMetierRetour();
		for(PartieI2M unePartie : reponseObtenirListePartiesI2M.getListeParties().getListeParties()){
			PartieMetierRetour partie = new PartieMetierRetour();
			partie.setNomPartie(unePartie.getNomPartie());
			partie.setNbJoueurPartie(unePartie.getNbJoueurPartie());
			listeParties.add(partie);
		}
		
		ReponseObtenirListePartiesM2PComportement reponseObtenirListePartiesM2P = new ReponseObtenirListePartiesM2PComportement(
				listeParties, 
				reponseObtenirListePartiesI2M.getListeParties().getMessageErreur(),
				reponseObtenirListePartiesI2M.getNumeroPresentation()
				);

		reponseObtenirListePartiesM2P.envoiMessage();
	}
}