package comportement.presentation2metier;

import comportement.Commande;
import comportement.metier2integration.DemanderNumeroPresentationM2IComportement;
import xml.presentation2metier.DemanderNumeroPresentationP2M;

public class DemanderNumeroPresentationP2MComportement implements Commande{
	private DemanderNumeroPresentationP2M demanderNumeroPresentationP2M;
	
	public DemanderNumeroPresentationP2MComportement(DemanderNumeroPresentationP2M demanderNumeroPresentationP2M){
		this.demanderNumeroPresentationP2M = demanderNumeroPresentationP2M;
	}
	
	public void reçoiMessage() {
		DemanderNumeroPresentationM2IComportement demanderNumeroPresentationComportement = new DemanderNumeroPresentationM2IComportement();
		demanderNumeroPresentationComportement.envoiMessage();	
	}

	public DemanderNumeroPresentationP2M getDemanderNumeroPresentationP2M() {
		return demanderNumeroPresentationP2M;
	}

	public void setDemanderNumeroPresentationP2M(DemanderNumeroPresentationP2M demanderNumeroPresentationP2M) {
		this.demanderNumeroPresentationP2M = demanderNumeroPresentationP2M;
	}
}