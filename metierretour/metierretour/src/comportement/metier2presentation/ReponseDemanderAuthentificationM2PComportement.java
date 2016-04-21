package comportement.metier2presentation;

import activeMQ.Producteur;
import comportement.Commande;
import xml.metier2presentation.CommandeM2P;
import xml.metier2presentation.ObjectFactory;
import xml.metier2presentation.ReponseDemanderAuthentificationM2P;


public class ReponseDemanderAuthentificationM2PComportement implements Commande {
	private boolean enregisrerDemanderAuthentification;

	public ReponseDemanderAuthentificationM2PComportement(boolean enregisrerDemanderAuthentification){
		this.enregisrerDemanderAuthentification = enregisrerDemanderAuthentification;
	}
	
	public void reçoiMessage() {
		
	}

	public void envoiMessage() {
		ObjectFactory objFactory = new ObjectFactory();
		CommandeM2P commande = objFactory.createCommandeM2P();
		commande.setEnregistrer(enregisrerDemanderAuthentification);
		
		ReponseDemanderAuthentificationM2P reponseDemanderAuthentificationM2P = objFactory.createReponseDemanderAuthentificationM2P();
		reponseDemanderAuthentificationM2P.setCommande(commande);
		
		new Producteur(reponseDemanderAuthentificationM2P);
	}

	public boolean isEnregisrerDemanderAuthentification() {
		return enregisrerDemanderAuthentification;
	}

	public void setEnregisrerDemanderAuthentification(boolean enregisrerDemanderAuthentification) {
		this.enregisrerDemanderAuthentification = enregisrerDemanderAuthentification;
	}
}