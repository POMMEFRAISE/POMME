package comportement.integration2metier;

import activeMQ.Producteur;
import xml.integration2metier.CommandeI2M;
import xml.integration2metier.ObjectFactory;
import xml.integration2metier.ReponseDemanderCreerPartieI2M;

public class ReponseDemanderCreerPartieI2MComportement{
	private boolean enregisrerDemanderCreerPartie;
	private int numeroPresentation;
	
	public ReponseDemanderCreerPartieI2MComportement(boolean enregisrerDemanderCreerPartie, int numeroPresentation){
		this.enregisrerDemanderCreerPartie = enregisrerDemanderCreerPartie;
		this.numeroPresentation = numeroPresentation;
	}
	
	public void envoiMessage(){
		ObjectFactory objFactory = new ObjectFactory();
		CommandeI2M commande = objFactory.createCommandeI2M();
		commande.setEnregistrer(enregisrerDemanderCreerPartie);
		
		ReponseDemanderCreerPartieI2M reponseDemanderCreerPartieI2M = objFactory.createReponseDemanderCreerPartieI2M();
		reponseDemanderCreerPartieI2M.setCommande(commande);
		reponseDemanderCreerPartieI2M.setNumeroPresentation(numeroPresentation);
		
		Thread thread = new Thread(new Producteur(reponseDemanderCreerPartieI2M));
		thread.start();
	}

	public int getNumeroPresentation() {
		return numeroPresentation;
	}

	public void setNumeroPresentation(int numeroPresentation) {
		this.numeroPresentation = numeroPresentation;
	}
}