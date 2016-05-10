package comportement.metier2integration;

import activeMQ.Producteur;
import xml.metier2integration.DemanderNumeroPresentationM2I;
import xml.metier2integration.ObjectFactory;

public class DemanderNumeroPresentationM2IComportement{
	
	public DemanderNumeroPresentationM2IComportement(){

	}
	
	public void envoiMessage(){
		ObjectFactory objFactory = new ObjectFactory();
		DemanderNumeroPresentationM2I demandeNumeroPresentationM2I = objFactory.createDemanderNumeroPresentationM2I();
		
		Thread thread = new Thread(new Producteur(demandeNumeroPresentationM2I));
		thread.start();
	}
}