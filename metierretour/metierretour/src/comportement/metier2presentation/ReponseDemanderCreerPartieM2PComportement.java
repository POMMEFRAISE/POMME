package comportement.metier2presentation;

import activeMQ.Producteur;
import xml.metier2presentation.CommandeM2P;
import xml.metier2presentation.ObjectFactory;
import xml.metier2presentation.ReponseDemanderCreerPartieM2P;

public class ReponseDemanderCreerPartieM2PComportement {
	private boolean enregisrerDemanderCreerPartie;
	private int numeroPresentation;
	
	public ReponseDemanderCreerPartieM2PComportement(boolean enregisrerDemanderCreerPartie, int numeroPresentation){
		this.enregisrerDemanderCreerPartie = enregisrerDemanderCreerPartie;
		this.numeroPresentation = numeroPresentation;
	}

	public void envoiMessage() {
		ObjectFactory objFactory = new ObjectFactory();
		CommandeM2P commande = objFactory.createCommandeM2P();
		commande.setEnregistrer(enregisrerDemanderCreerPartie);
		
		ReponseDemanderCreerPartieM2P reponseDemanderCreerPartieM2P = objFactory.createReponseDemanderCreerPartieM2P();
		reponseDemanderCreerPartieM2P.setCommande(commande);
		
		Thread thread = new Thread(new Producteur(reponseDemanderCreerPartieM2P, numeroPresentation));
		thread.start();
	}

	public int getNumeroPresentation() {
		return numeroPresentation;
	}

	public void setNumeroPresentation(int numeroPresentation) {
		this.numeroPresentation = numeroPresentation;
	}

	public boolean isEnregisrerDemanderCreerPartie() {
		return enregisrerDemanderCreerPartie;
	}

	public void setEnregisrerDemanderCreerPartie(boolean enregisrerDemanderCreerPartie) {
		this.enregisrerDemanderCreerPartie = enregisrerDemanderCreerPartie;
	}
}