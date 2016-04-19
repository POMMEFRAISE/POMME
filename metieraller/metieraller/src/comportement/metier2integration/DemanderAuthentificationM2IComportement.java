package comportement.metier2integration;

import activeMQ.Producteur;
import comportement.Commande;
import xml.metier2integration.DemanderAuthentificationM2I;
import xml.metier2integration.ObjectFactory;

public class DemanderAuthentificationM2IComportement implements Commande{
	
	public DemanderAuthentificationM2IComportement(){

	}
	
	public void reçoiMessage() {
	
	}
	
	public void envoiMessage(){
		ObjectFactory objFactory = new ObjectFactory();
		DemanderAuthentificationM2I demandeAuthentificationM2I = objFactory.createDemanderAuthentificationM2I();
		
		new Producteur(demandeAuthentificationM2I);
	}
}