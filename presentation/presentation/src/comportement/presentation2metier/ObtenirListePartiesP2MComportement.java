package comportement.presentation2metier;

import activeMQ.Producteur;
import xml.presentation2metier.ObjectFactory;
import xml.presentation2metier.ObtenirListePartiesP2M;

public class ObtenirListePartiesP2MComportement{
	
	private int numeroPresentation;
	
	public ObtenirListePartiesP2MComportement(int numeroPresentation){
		this.numeroPresentation = numeroPresentation;
	}

	public void envoiMessage() {
		ObjectFactory objFactory = new ObjectFactory();
		ObtenirListePartiesP2M obtenirListeParties = objFactory.createObtenirListePartiesP2M();
		obtenirListeParties.setNumeroPresentation(numeroPresentation);
		new Producteur(obtenirListeParties);	
	}

	public int getNumeroPresentation() {
		return numeroPresentation;
	}

	public void setNumeroPresentation(int numeroPresentation) {
		this.numeroPresentation = numeroPresentation;
	}
}