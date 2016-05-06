package comportement.metier2presentation;

import activeMQ.Producteur;
import xml.metier2presentation.CommandeM2P;
import xml.metier2presentation.ObjectFactory;
import xml.metier2presentation.ReponseDemanderRejoindrePartieM2P;

public class ReponseDemanderRejoindrePartieM2PComportement {
	private boolean enregisrerDemanderCreerPartie;
	private int numeroPresentation;
	
	public ReponseDemanderRejoindrePartieM2PComportement(boolean enregisrerDemanderCreerPartie, int numeroPresentation){
		this.enregisrerDemanderCreerPartie = enregisrerDemanderCreerPartie;
		this.numeroPresentation = numeroPresentation;
	}

	public void envoiMessage() {
		ObjectFactory objFactory = new ObjectFactory();
		CommandeM2P commande = objFactory.createCommandeM2P();
		commande.setEnregistrer(enregisrerDemanderCreerPartie);
		
		ReponseDemanderRejoindrePartieM2P reponseDemanderRejoindrePartieM2P = objFactory.createReponseDemanderRejoindrePartieM2P();
		reponseDemanderRejoindrePartieM2P.setCommande(commande);
		
		new Producteur(reponseDemanderRejoindrePartieM2P, numeroPresentation);
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