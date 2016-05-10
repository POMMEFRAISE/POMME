package comportement.integration2metier;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import activeMQ.Producteur;
import xml.integration2metier.ListePartiesI2M;
import xml.integration2metier.ObjectFactory;
import xml.integration2metier.PartieI2M;
import xml.integration2metier.ReponseObtenirListePartiesI2M;

public class ReponseObtenirListePartiesI2MComportement{
	private ArrayList<Object> listePartiesDTO;
	private String messageErreur;
	private int numeroPresentation;
	
	public ReponseObtenirListePartiesI2MComportement(ArrayList<Object> listePartiesDTO, String messageErreur, int numeroPresentation){
		this.listePartiesDTO = listePartiesDTO;
		this.messageErreur = messageErreur;
		this.numeroPresentation = numeroPresentation;
	}
	
	public void envoiMessage() {
		ObjectFactory objFactory = new ObjectFactory();
		ListePartiesI2M parties = objFactory.createListePartiesI2M();
				
		for(Object unePartie : listePartiesDTO){
			PartieI2M partie = objFactory.createPartieI2M();
			try {
				partie.setNomPartie(unePartie.getClass().getMethod("getNomPartie").invoke(unePartie).toString());
				partie.setNbJoueurPartie((Integer) unePartie.getClass().getMethod("getNbredejoueur").invoke(unePartie));
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
					| SecurityException e) {
				e.printStackTrace();
			}	
			parties.getListeParties().add(partie);

		}
		parties.setMessageErreur(messageErreur);
		
		ReponseObtenirListePartiesI2M reponseObtenirListeParties = objFactory.createReponseObtenirListePartiesI2M();
		reponseObtenirListeParties.setListeParties(parties);
		reponseObtenirListeParties.setNumeroPresentation(numeroPresentation);
		
		Thread thread = new Thread(new Producteur(reponseObtenirListeParties));
		thread.start();
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
}