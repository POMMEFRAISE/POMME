package comportement.integration2metier;

import activeMQ.Producteur;
import xml.integration2metier.CommandeI2M;
import xml.integration2metier.ObjectFactory;
import xml.integration2metier.ReponseDemanderRejoindrePartieI2M;

public class ReponseDemanderRejoindrePartieI2MComportement{
	private boolean enregisrerDemanderRejoindrePartie;
	private int numeroPresentation;
	
	public ReponseDemanderRejoindrePartieI2MComportement(boolean enregisrerDemanderRejoindrePartie, int numeroPresentation){
		this.enregisrerDemanderRejoindrePartie = enregisrerDemanderRejoindrePartie;
		this.numeroPresentation = numeroPresentation;
	}
	
	public void envoiMessage(){
		ObjectFactory objFactory = new ObjectFactory();
		CommandeI2M commande = objFactory.createCommandeI2M();
		commande.setEnregistrer(enregisrerDemanderRejoindrePartie);
		
		ReponseDemanderRejoindrePartieI2M reponseDemanderRejoindrePartieI2M = objFactory.createReponseDemanderRejoindrePartieI2M();
		reponseDemanderRejoindrePartieI2M.setCommande(commande);
		reponseDemanderRejoindrePartieI2M.setNumeroPresentation(numeroPresentation);
		
		new Producteur(reponseDemanderRejoindrePartieI2M);
	}

	public int getNumeroPresentation() {
		return numeroPresentation;
	}

	public void setNumeroPresentation(int numeroPresentation) {
		this.numeroPresentation = numeroPresentation;
	}
}