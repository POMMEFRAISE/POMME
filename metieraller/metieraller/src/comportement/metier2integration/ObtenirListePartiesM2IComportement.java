package comportement.metier2integration;

import activeMQ.Producteur;
import xml.metier2integration.ObtenirListePartiesM2I;
import xml.metier2integration.ObjectFactory;

public class ObtenirListePartiesM2IComportement{
	
	private int numeroPresentation;
	
	public ObtenirListePartiesM2IComportement(int numeroPresentation){
		this.numeroPresentation = numeroPresentation;
	}
	
	public void envoiMessage(){
		ObjectFactory objFactory = new ObjectFactory();
		ObtenirListePartiesM2I obtenirListePartiesM2I = objFactory.createObtenirListePartiesM2I();
		obtenirListePartiesM2I.setNumeroPresentation(numeroPresentation);
		
		new Producteur(obtenirListePartiesM2I);
	}

	public int getNumeroPresentation() {
		return numeroPresentation;
	}

	public void setNumeroPresentation(int numeroPresentation) {
		this.numeroPresentation = numeroPresentation;
	}
}