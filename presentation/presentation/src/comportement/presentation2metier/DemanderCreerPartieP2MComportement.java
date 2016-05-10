package comportement.presentation2metier;

import activeMQ.Producteur;
import xml.presentation2metier.DemanderCreerPartieP2M;
import xml.presentation2metier.ObjectFactory;

public class DemanderCreerPartieP2MComportement{
	
	private int numeroPresentation;
	
	public DemanderCreerPartieP2MComportement(int numeroPresentation){
		this.numeroPresentation = numeroPresentation;
	}

	public void envoiMessage() {
		ObjectFactory objFactory = new ObjectFactory();
		DemanderCreerPartieP2M demandeCreerPartie = objFactory.createDemanderCreerPartieP2M();
		demandeCreerPartie.setNumeroPresentation(numeroPresentation);
		
		Thread thread = new Thread(new Producteur(demandeCreerPartie));
		thread.start();
	}

	public int getNumeroPresentation() {
		return numeroPresentation;
	}

	public void setNumeroPresentation(int numeroPresentation) {
		this.numeroPresentation = numeroPresentation;
	}
}