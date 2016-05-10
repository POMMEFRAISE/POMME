package comportement.metier2presentation;

import activeMQ.Producteur;
import xml.metier2presentation.CommandeM2P;
import xml.metier2presentation.ObjectFactory;
import xml.metier2presentation.ReponseDemanderAuthentificationM2P;

public class ReponseDemanderAuthentificationM2PComportement {
	private boolean enregisrerDemanderAuthentification;
	private int numeroPresentation;
	
	public ReponseDemanderAuthentificationM2PComportement(boolean enregisrerDemanderAuthentification, int numeroPresentation){
		this.enregisrerDemanderAuthentification = enregisrerDemanderAuthentification;
		this.numeroPresentation = numeroPresentation;
	}

	public void envoiMessage() {
		ObjectFactory objFactory = new ObjectFactory();
		CommandeM2P commande = objFactory.createCommandeM2P();
		commande.setEnregistrer(enregisrerDemanderAuthentification);
		
		ReponseDemanderAuthentificationM2P reponseDemanderAuthentificationM2P = objFactory.createReponseDemanderAuthentificationM2P();
		reponseDemanderAuthentificationM2P.setCommande(commande);
		
		Thread thread = new Thread(new Producteur(reponseDemanderAuthentificationM2P, numeroPresentation));
		thread.start();
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