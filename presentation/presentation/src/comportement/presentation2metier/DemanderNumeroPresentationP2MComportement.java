package comportement.presentation2metier;

import activeMQ.Producteur;
import xml.presentation2metier.DemanderNumeroPresentationP2M;
import xml.presentation2metier.ObjectFactory;

public class DemanderNumeroPresentationP2MComportement {

	public DemanderNumeroPresentationP2MComportement(){

	}
	
	public void envoiMessage() {
		ObjectFactory objFactory = new ObjectFactory();
		DemanderNumeroPresentationP2M demandeNumeroPresentation = objFactory.createDemanderNumeroPresentationP2M();
		
		Thread thread = new Thread(new Producteur(demandeNumeroPresentation));
		thread.start();
	}
}