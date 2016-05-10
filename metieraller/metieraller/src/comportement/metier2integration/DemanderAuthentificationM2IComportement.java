package comportement.metier2integration;

import activeMQ.Producteur;
import xml.metier2integration.DemanderAuthentificationM2I;
import xml.metier2integration.ObjectFactory;

public class DemanderAuthentificationM2IComportement{
	
	private int numeroPresentation;
	
	public DemanderAuthentificationM2IComportement(int numeroPresentation){
		this.numeroPresentation = numeroPresentation;
	}
	
	public void envoiMessage(){
		ObjectFactory objFactory = new ObjectFactory();
		DemanderAuthentificationM2I demandeAuthentificationM2I = objFactory.createDemanderAuthentificationM2I();
		demandeAuthentificationM2I.setNumeroPresentation(numeroPresentation);
		
		Thread thread = new Thread(new Producteur(demandeAuthentificationM2I));
		thread.start();
	}

	public int getNumeroPresentation() {
		return numeroPresentation;
	}

	public void setNumeroPresentation(int numeroPresentation) {
		this.numeroPresentation = numeroPresentation;
	}
}