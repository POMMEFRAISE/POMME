package comportement.metier2presentation;

import activeMQ.Producteur;
import model.PartieMetierRetour;
import model.PartiesMetierRetour;
import xml.metier2presentation.ListePartiesM2P;
import xml.metier2presentation.ObjectFactory;
import xml.metier2presentation.PartieM2P;
import xml.metier2presentation.ReponseObtenirListePartiesM2P;

public class ReponseObtenirListePartiesM2PComportement{
	private PartiesMetierRetour partiesMetier;
	private String messageErreur;
	private int numeroPresentation;
	
	public ReponseObtenirListePartiesM2PComportement(PartiesMetierRetour partiesMetier, String messageErreur, int numeroPresentation){
		this.partiesMetier = partiesMetier;
		this.messageErreur = messageErreur;
		this.numeroPresentation = numeroPresentation;
	}
	
	public void envoiMessage() {
		ObjectFactory objFactory = new ObjectFactory();
		ListePartiesM2P parties = objFactory.createListePartiesM2P();

		for(PartieMetierRetour unePartie : partiesMetier.getParties()){
			PartieM2P partie = objFactory.createPartieM2P();
			partie.setNomPartie(unePartie.getNomPartie());
			partie.setNbJoueurPartie(unePartie.getNbJoueurPartie());
			parties.getListeParties().add(partie);
		}
		parties.setMessageErreur(messageErreur);
		
		ReponseObtenirListePartiesM2P reponseObtenirListeParties = objFactory.createReponseObtenirListePartiesM2P();
		reponseObtenirListeParties.setListeParties(parties);
		
		new Producteur(reponseObtenirListeParties, numeroPresentation);
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

	public PartiesMetierRetour getPartiesMetier() {
		return partiesMetier;
	}

	public void setPartiesMetier(PartiesMetierRetour partiesMetier) {
		this.partiesMetier = partiesMetier;
	}
}