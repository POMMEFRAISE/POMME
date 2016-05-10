package comportement.metier2integration;

import activeMQ.Producteur;
import xml.metier2integration.DemanderCreerPartieM2I;
import xml.metier2integration.ObjectFactory;

public class DemanderCreerPartieM2IComportement{
	
	private int numeroPresentation;
	
	public DemanderCreerPartieM2IComportement(int numeroPresentation){
		this.numeroPresentation = numeroPresentation;
	}
	
	public void envoiMessage(){
		ObjectFactory objFactory = new ObjectFactory();
		DemanderCreerPartieM2I demandeCreerPartieM2I = objFactory.createDemanderCreerPartieM2I();
		demandeCreerPartieM2I.setNumeroPresentation(numeroPresentation);
		
		Thread thread = new Thread(new Producteur(demandeCreerPartieM2I));
		thread.start();
	}

	public int getNumeroPresentation() {
		return numeroPresentation;
	}

	public void setNumeroPresentation(int numeroPresentation) {
		this.numeroPresentation = numeroPresentation;
	}
}