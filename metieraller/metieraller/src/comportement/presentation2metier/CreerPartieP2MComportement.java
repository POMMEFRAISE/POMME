package comportement.presentation2metier;

import comportement.Commande;
import comportement.metier2integration.CreerPartieM2IComportement;
import xml.presentation2metier.CreerPartieP2M;

public class CreerPartieP2MComportement implements Commande{
	private CreerPartieP2M creerPartieP2M;
	
	public CreerPartieP2MComportement(CreerPartieP2M creerPartieP2M){
		this.creerPartieP2M = creerPartieP2M;
	}
	
	public void reçoiMessage() {
		CreerPartieM2IComportement creerPartieM2I = new CreerPartieM2IComportement(
				creerPartieP2M.getCreationPartie().getNomPartie(),
				creerPartieP2M.getCreationPartie().getNbJoueurPartie(),
				creerPartieP2M.getNumeroPresentation()
		);
		creerPartieM2I.envoiMessage();
	}

	public CreerPartieP2M getCreerPartieP2M() {
		return creerPartieP2M;
	}

	public void setCreerPartieP2M(CreerPartieP2M creerPartieP2M) {
		this.creerPartieP2M = creerPartieP2M;
	}
}