package comportement.integration2metier;

import activeMQ.Producteur;
import xml.integration2metier.ObjectFactory;
import xml.integration2metier.ReponseDemanderNumeroPresentationI2M;

public class ReponseDemanderNumeroPresentationI2MComportement{
	private int numeroPresentation;
	public ReponseDemanderNumeroPresentationI2MComportement(int numeroPresentation){
		this.numeroPresentation = numeroPresentation;
	}
	
	public void envoiMessage(){
		ObjectFactory objFactory = new ObjectFactory();
		
		ReponseDemanderNumeroPresentationI2M reponseDemanderNumeroPresentationI2M = objFactory.createReponseDemanderNumeroPresentationI2M();
		reponseDemanderNumeroPresentationI2M.setNumeroPresentation(numeroPresentation);
		
		Thread thread = new Thread(new Producteur(reponseDemanderNumeroPresentationI2M));
		thread.start();
	}

	public int getNumeroPresentation() {
		return numeroPresentation;
	}

	public void setNumeroPresentation(int numeroPresentation) {
		this.numeroPresentation = numeroPresentation;
	}
}