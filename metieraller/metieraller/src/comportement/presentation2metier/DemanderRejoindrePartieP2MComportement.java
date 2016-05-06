package comportement.presentation2metier;

import comportement.Commande;
import comportement.metier2integration.DemanderRejoindrePartieM2IComportement;
import xml.presentation2metier.DemanderRejoindrePartieP2M;

public class DemanderRejoindrePartieP2MComportement implements Commande{
	private DemanderRejoindrePartieP2M demanderRejoindrePartieP2M;
	
	public DemanderRejoindrePartieP2MComportement(DemanderRejoindrePartieP2M demanderRejoindrePartieP2M){
		this.demanderRejoindrePartieP2M = demanderRejoindrePartieP2M;
	}
	
	public void reçoiMessage() {
		DemanderRejoindrePartieM2IComportement demanderRejoindrePartieComportement = 
				new DemanderRejoindrePartieM2IComportement(demanderRejoindrePartieP2M.getNumeroPresentation());
		demanderRejoindrePartieComportement.envoiMessage();	
	}

	public DemanderRejoindrePartieP2M getDemanderRejoindrePartieP2M() {
		return demanderRejoindrePartieP2M;
	}

	public void setDemanderRejoindrePartieP2M(DemanderRejoindrePartieP2M demanderRejoindrePartieP2M) {
		this.demanderRejoindrePartieP2M = demanderRejoindrePartieP2M;
	}
}