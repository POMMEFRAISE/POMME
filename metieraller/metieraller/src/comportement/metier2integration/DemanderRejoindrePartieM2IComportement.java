package comportement.metier2integration;

import activeMQ.Producteur;
import xml.metier2integration.DemanderRejoindrePartieM2I;
import xml.metier2integration.ObjectFactory;

public class DemanderRejoindrePartieM2IComportement{
	
	private int numeroPresentation;
	
	public DemanderRejoindrePartieM2IComportement(int numeroPresentation){
		this.numeroPresentation = numeroPresentation;
	}
	
	public void envoiMessage(){
		ObjectFactory objFactory = new ObjectFactory();
		DemanderRejoindrePartieM2I demandeRejoindrePartieM2I = objFactory.createDemanderRejoindrePartieM2I();
		demandeRejoindrePartieM2I.setNumeroPresentation(numeroPresentation);
		
		Thread thread = new Thread(new Producteur(demandeRejoindrePartieM2I));
		thread.start();
	}

	public int getNumeroPresentation() {
		return numeroPresentation;
	}

	public void setNumeroPresentation(int numeroPresentation) {
		this.numeroPresentation = numeroPresentation;
	}
}