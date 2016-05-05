package comportement.integration2metier;

import activeMQ.Producteur;
import xml.integration2metier.CommandeI2M;
import xml.integration2metier.ObjectFactory;
import xml.integration2metier.ReponseDemanderAuthentificationI2M;

public class ReponseDemanderAuthentificationI2MComportement{
	private boolean enregisrerDemanderAuthentification;
	private int numeroPresentation;
	
	public ReponseDemanderAuthentificationI2MComportement(boolean enregisrerDemanderAuthentification, int numeroPresentation){
		this.enregisrerDemanderAuthentification = enregisrerDemanderAuthentification;
		this.numeroPresentation = numeroPresentation;
	}
	
	public void envoiMessage(){
		ObjectFactory objFactory = new ObjectFactory();
		CommandeI2M commande = objFactory.createCommandeI2M();
		commande.setEnregistrer(enregisrerDemanderAuthentification);
		
		ReponseDemanderAuthentificationI2M reponseDemanderAuthentificationI2M = objFactory.createReponseDemanderAuthentificationI2M();
		reponseDemanderAuthentificationI2M.setCommande(commande);
		reponseDemanderAuthentificationI2M.setNumeroPresentation(numeroPresentation);
		
		new Producteur(reponseDemanderAuthentificationI2M);
	}

	public boolean isEnregisrerDemanderAuthentification() {
		return enregisrerDemanderAuthentification;
	}

	public void setEnregisrerDemanderAuthentification(boolean enregisrerDemanderAuthentification) {
		this.enregisrerDemanderAuthentification = enregisrerDemanderAuthentification;
	}

	public int getNumeroPresentation() {
		return numeroPresentation;
	}

	public void setNumeroPresentation(int numeroPresentation) {
		this.numeroPresentation = numeroPresentation;
	}
}