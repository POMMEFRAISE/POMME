package comportement.presentation2metier;

import activeMQ.Producteur;
import xml.presentation2metier.CreationPartieP2M;
import xml.presentation2metier.CreerPartieP2M;
import xml.presentation2metier.ObjectFactory;

public class CreerPartieP2MComportement{
	private String nomPartie;
	private int nbJoueurPartie;
	private int numeroPresentation;

	public CreerPartieP2MComportement(String nomPartie, int nbJoueurPartie, int numeroPresentation){
		this.nomPartie = nomPartie;
		this.nbJoueurPartie = nbJoueurPartie;
		this.numeroPresentation = numeroPresentation;
	}
	
	public void envoiMessage() {
		ObjectFactory objFactory = new ObjectFactory();

	    CreationPartieP2M creationPartie = objFactory.createCreationPartieP2M();
	    creationPartie.setNomParrtie(nomPartie);
	    creationPartie.setNbJoueurPartie(nbJoueurPartie);
	    
		CreerPartieP2M creerPartie = objFactory.createCreerPartieP2M();
		creerPartie.setCreationPartie(creationPartie);
		creerPartie.setNumeroPresentation(numeroPresentation);
		
		new Producteur(creerPartie);		
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
}