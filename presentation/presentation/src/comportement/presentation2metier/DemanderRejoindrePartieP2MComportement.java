package comportement.presentation2metier;

import activeMQ.Producteur;
import xml.presentation2metier.DemanderRejoindrePartieP2M;
import xml.presentation2metier.ObjectFactory;

public class DemanderRejoindrePartieP2MComportement{
	
	private int numeroPresentation;
	
	public DemanderRejoindrePartieP2MComportement(int numeroPresentation){
		this.numeroPresentation = numeroPresentation;
	}

	public void envoiMessage() {
		ObjectFactory objFactory = new ObjectFactory();
		DemanderRejoindrePartieP2M demandeRejoindrePartie = objFactory.createDemanderRejoindrePartieP2M();
		demandeRejoindrePartie.setNumeroPresentation(numeroPresentation);
		new Producteur(demandeRejoindrePartie);	
	}

	public int getNumeroPresentation() {
		return numeroPresentation;
	}

	public void setNumeroPresentation(int numeroPresentation) {
		this.numeroPresentation = numeroPresentation;
	}
}