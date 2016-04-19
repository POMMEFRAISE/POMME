package comportement.metier2presentation;

import activeMQ.Producteur;
import comportement.Commande;
import xml.metier2presentation.ObjectFactory;
import xml.metier2presentation.ReponseDemanderAuthentificationM2P;

public class ReponseDemanderAuthentificationM2PComportement implements Commande {

	public void reçoiMessage() {
		
	}

	public void envoiMessage() {
		ObjectFactory objFactory = new ObjectFactory();
		ReponseDemanderAuthentificationM2P reponseDemandeAuthentificationM2P = objFactory.createReponseDemanderAuthentificationM2P();
		
		new Producteur(reponseDemandeAuthentificationM2P);
	}
}