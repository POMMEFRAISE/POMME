package comportement.presentation2metier;

import activeMQ.Producteur;
import xml.presentation2metier.DemanderAuthentificationP2M;
import xml.presentation2metier.ObjectFactory;

public class DemanderAuthentificationP2MComportement{
	
	private int numeroPresentation;
	
	public DemanderAuthentificationP2MComportement(int numeroPresentation){
		this.numeroPresentation = numeroPresentation;
	}

	public void envoiMessage() {
		ObjectFactory objFactory = new ObjectFactory();
		DemanderAuthentificationP2M demandeAuthentification = objFactory.createDemanderAuthentificationP2M();
		demandeAuthentification.setNumeroPresentation(numeroPresentation);
	
		Thread thread = new Thread(new Producteur(demandeAuthentification));
		thread.start();
	}

	public int getNumeroPresentation() {
		return numeroPresentation;
	}

	public void setNumeroPresentation(int numeroPresentation) {
		this.numeroPresentation = numeroPresentation;
	}
}