package comportement.metier2presentation;

import activeMQ.Producteur;
import model.PartieMetierRetour;
import xml.metier2presentation.CreationPartieM2P;
import xml.metier2presentation.ObjectFactory;
import xml.metier2presentation.PartieM2P;
import xml.metier2presentation.ReponseCreerPartieM2P;

public class ReponseCreerPartieM2PComportement{
	private PartieMetierRetour partieMetier;
	private String messageErreur;
	private int numeroPresentation;
	
	public ReponseCreerPartieM2PComportement(PartieMetierRetour partieMetier, String messageErreur, int numeroPresentation){
		this.partieMetier = partieMetier;
		this.messageErreur = messageErreur;
		this.numeroPresentation = numeroPresentation;
	}
	
	public void envoiMessage() {
		ObjectFactory objFactory = new ObjectFactory();
		PartieM2P partie = objFactory.createPartieM2P();
		partie.setNomPartie(partieMetier.getNomPartie());
		partie.setNbJoueurPartie(partieMetier.getNbJoueurPartie());
		CreationPartieM2P creationPartie = objFactory.createCreationPartieM2P();
		creationPartie.setPartie(partie);
		creationPartie.setMessageErreur(messageErreur);
		ReponseCreerPartieM2P reponseCreerPartie = objFactory.createReponseCreerPartieM2P();
		reponseCreerPartie.setCreationPartie(creationPartie);
		
		new Producteur(reponseCreerPartie, numeroPresentation);
	}

	public String getMessageErreur() {
		return messageErreur;
	}

	public void setMessageErreur(String messageErreur) {
		this.messageErreur = messageErreur;
	}

	public int getNumeroPresentation() {
		return numeroPresentation;
	}

	public void setNumeroPresentation(int numeroPresentation) {
		this.numeroPresentation = numeroPresentation;
	}

	public PartieMetierRetour getPartieMetier() {
		return partieMetier;
	}

	public void setPartieMetier(PartieMetierRetour partieMetier) {
		this.partieMetier = partieMetier;
	}
}