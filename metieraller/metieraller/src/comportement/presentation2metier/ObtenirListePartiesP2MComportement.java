package comportement.presentation2metier;

import comportement.Commande;
import comportement.metier2integration.ObtenirListePartiesM2IComportement;
import xml.presentation2metier.ObtenirListePartiesP2M;

public class ObtenirListePartiesP2MComportement implements Commande{
	private ObtenirListePartiesP2M obtenirListePartiesP2M;
	
	public ObtenirListePartiesP2MComportement(ObtenirListePartiesP2M obtenirListePartiesP2M){
		this.obtenirListePartiesP2M = obtenirListePartiesP2M;
	}
	
	public void reçoiMessage() {
		ObtenirListePartiesM2IComportement obtenirListePartiesComportement = 
				new ObtenirListePartiesM2IComportement(obtenirListePartiesP2M.getNumeroPresentation());
		obtenirListePartiesComportement.envoiMessage();	
	}

	public ObtenirListePartiesP2M getObtenirListePartiesP2M() {
		return obtenirListePartiesP2M;
	}

	public void setObtenirListePartiesP2M(ObtenirListePartiesP2M obtenirListePartiesP2M) {
		this.obtenirListePartiesP2M = obtenirListePartiesP2M;
	}
}