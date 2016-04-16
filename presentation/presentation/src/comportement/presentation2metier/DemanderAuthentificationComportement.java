package comportement.presentation2metier;

import activeMQ.Producteur;
import comportement.Commande;
import xml.presentation2metier.DemanderAuthentification;
import xml.presentation2metier.ObjectFactory;

public class DemanderAuthentificationComportement implements Commande{
	
	public DemanderAuthentificationComportement(){

	}

	public void envoiMessage() {
		ObjectFactory objFactory = new ObjectFactory();
		DemanderAuthentification demandeAuthentification = objFactory.createDemanderAuthentification();
		
		new Producteur(demandeAuthentification);	
	}

	public String reçoiMessage() {
		return "";
	}
}