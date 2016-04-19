package comportement.presentation2metier;

import activeMQ.Producteur;
import comportement.Commande;
import xml.presentation2metier.DemanderAuthentificationP2M;
import xml.presentation2metier.ObjectFactory;

public class DemanderAuthentificationP2MComportement implements Commande{
	
	public DemanderAuthentificationP2MComportement(){

	}

	public void envoiMessage() {
		ObjectFactory objFactory = new ObjectFactory();
		DemanderAuthentificationP2M demandeAuthentification = objFactory.createDemanderAuthentificationP2M();
		
		new Producteur(demandeAuthentification);	
	}

	public String reçoiMessage() {
		return "";
	}
}