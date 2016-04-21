package comportement.integration2metier;

import activeMQ.Producteur;
import comportement.Commande;
import xml.integration2metier.CommandeI2M;
import xml.integration2metier.ObjectFactory;
import xml.integration2metier.ReponseDemanderAuthentificationI2M;

public class ReponseDemanderAuthentificationI2MComportement implements Commande{
	private boolean enregisrerDemanderAuthentification;
	public ReponseDemanderAuthentificationI2MComportement(boolean enregisrerDemanderAuthentification){
		this.enregisrerDemanderAuthentification = enregisrerDemanderAuthentification;
	}
	
	public void reçoiMessage() {

	}
	
	public void envoiMessage(){
		ObjectFactory objFactory = new ObjectFactory();
		CommandeI2M commande = objFactory.createCommandeI2M();
		commande.setEnregistrer(enregisrerDemanderAuthentification);
		
		ReponseDemanderAuthentificationI2M reponseDemanderAuthentificationI2M = objFactory.createReponseDemanderAuthentificationI2M();
		reponseDemanderAuthentificationI2M.setCommande(commande);
		
		new Producteur(reponseDemanderAuthentificationI2M);
	}

	public boolean isEnregisrerDemanderAuthentification() {
		return enregisrerDemanderAuthentification;
	}

	public void setEnregisrerDemanderAuthentification(boolean enregisrerDemanderAuthentification) {
		this.enregisrerDemanderAuthentification = enregisrerDemanderAuthentification;
	}
}