package comportement.metier2presentation;

import activeMQ.Producteur;
import xml.metier2presentation.ObjectFactory;
import xml.metier2presentation.ReponseDemanderNumeroPresentationM2P;

public class ReponseDemanderNumeroPresentationM2PComportement {
	private int numeroPresentation;

	public ReponseDemanderNumeroPresentationM2PComportement(int numeroPresentation){
		this.numeroPresentation = numeroPresentation;
	}

	public void envoiMessage() {
		ObjectFactory objFactory = new ObjectFactory();
		
		ReponseDemanderNumeroPresentationM2P reponseDemanderNumeroPresentationM2P = objFactory.createReponseDemanderNumeroPresentationM2P();
		reponseDemanderNumeroPresentationM2P.setNumeroPresentation(numeroPresentation);
		
		new Producteur(reponseDemanderNumeroPresentationM2P);
	}

	public int getNumeroPresentation() {
		return numeroPresentation;
	}

	public void setNumeroPresentation(int numeroPresentation) {
		this.numeroPresentation = numeroPresentation;
	}
}