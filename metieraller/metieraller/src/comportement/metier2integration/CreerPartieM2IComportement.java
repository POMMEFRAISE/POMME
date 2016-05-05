package comportement.metier2integration;

import activeMQ.Producteur;
import xml.metier2integration.CreationPartieM2I;
import xml.metier2integration.CreerPartieM2I;
import xml.metier2integration.ObjectFactory;

public class CreerPartieM2IComportement{
	private String nomPartie;
	private int nbJoueurPartie;
	private String messageErreur = "";
	private int numeroPresentation;
	
	public CreerPartieM2IComportement(String nomPartie, int nbJoueurPartie, int numeroPresentation){
		this.nomPartie = nomPartie;
		this.nbJoueurPartie = nbJoueurPartie;
		this.numeroPresentation = numeroPresentation;
	}
	
	public String getMessageErreur() {
		return messageErreur;
	}

	public void setMessageErreur(String messageErreur) {
		this.messageErreur = messageErreur;
	}
	
	public void envoiMessage() {
		if(nomPartie.equals("") || nomPartie == null){
			messageErreur = "Le nom de la partie doit être renseignée\n";
		}
		if(nbJoueurPartie <3 || nbJoueurPartie >7){
			messageErreur = messageErreur+"Le nombre de joueur doit être compris entre 3 et 7";
		}
		ObjectFactory objFactory = new ObjectFactory();
		CreationPartieM2I creationPartieM2I = objFactory.createCreationPartieM2I();
		creationPartieM2I.setNomPartie(nomPartie);
		creationPartieM2I.setNbJoueurPartie(nbJoueurPartie);
		creationPartieM2I.setMessageErreur(messageErreur);
		CreerPartieM2I creerPartieM2I = objFactory.createCreerPartieM2I();
		creerPartieM2I.setCreationPartie(creationPartieM2I);
		creerPartieM2I.setNumeroPresentation(numeroPresentation);
		
		new Producteur(creerPartieM2I);
	}

	public int getNumeroPresentation() {
		return numeroPresentation;
	}

	public void setNumeroPresentation(int numeroPresentation) {
		this.numeroPresentation = numeroPresentation;
	}

	public int getNbJoueurPartie() {
		return nbJoueurPartie;
	}

	public void setNbJoueurPartie(int nbJoueurPartie) {
		this.nbJoueurPartie = nbJoueurPartie;
	}

	public String getNomPartie() {
		return nomPartie;
	}

	public void setNomPartie(String nomPartie) {
		this.nomPartie = nomPartie;
	}
}