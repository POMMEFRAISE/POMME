package comportement.presentation2metier;

import comportement.Commande;
import comportement.metier2integration.DemanderCreerPartieM2IComportement;
import xml.presentation2metier.DemanderCreerPartieP2M;

public class DemanderCreerPartieP2MComportement implements Commande{
	private DemanderCreerPartieP2M demanderCreerPartieP2M;
	
	public DemanderCreerPartieP2MComportement(DemanderCreerPartieP2M demanderCreerPartieP2M){
		this.demanderCreerPartieP2M = demanderCreerPartieP2M;
	}
	
	public void reçoiMessage() {
		DemanderCreerPartieM2IComportement demanderCreerPartieComportement = 
				new DemanderCreerPartieM2IComportement(demanderCreerPartieP2M.getNumeroPresentation());
		demanderCreerPartieComportement.envoiMessage();	
	}

	public DemanderCreerPartieP2M getDemanderCreerPartieP2M() {
		return demanderCreerPartieP2M;
	}

	public void setDemanderCreerPartieP2M(DemanderCreerPartieP2M demanderCreerPartieP2M) {
		this.demanderCreerPartieP2M = demanderCreerPartieP2M;
	}
}