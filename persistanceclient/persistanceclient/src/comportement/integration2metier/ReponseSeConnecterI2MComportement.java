package comportement.integration2metier;

import java.lang.reflect.InvocationTargetException;

import activeMQ.Producteur;
import xml.integration2metier.AuthentificationI2M;
import xml.integration2metier.JoueurI2M;
import xml.integration2metier.ObjectFactory;
import xml.integration2metier.ReponseSeConnecterI2M;

public class ReponseSeConnecterI2MComportement {
	private String messageErreur;
	private Object joueurDTO;
	private int numeroPresentation;
	
	public ReponseSeConnecterI2MComportement(String messageErreur, Object joueurDTO, int numeroPresentation){
		this.messageErreur = messageErreur;	
		this.joueurDTO = joueurDTO;
		this.numeroPresentation = numeroPresentation;
	}
	
	public void envoiMessage(){
		ObjectFactory objFactory = new ObjectFactory();
		JoueurI2M joueur = objFactory.createJoueurI2M();

		try {
			joueur.setLoginJoueur(joueurDTO.getClass().getMethod("getLogin").invoke(joueurDTO).toString());
			joueur.setNomJoueur(joueurDTO.getClass().getMethod("getNom").invoke(joueurDTO).toString());
			joueur.setPrenomJoueur(joueurDTO.getClass().getMethod("getPrenom").invoke(joueurDTO).toString());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			e.printStackTrace();
		}
		AuthentificationI2M authentification = objFactory.createAuthentificationI2M();
		authentification.setJoueur(joueur);
		authentification.setMessageErreur(messageErreur);
		ReponseSeConnecterI2M reponseSeConnecter = objFactory.createReponseSeConnecterI2M();
		reponseSeConnecter.setAuthentification(authentification);
		reponseSeConnecter.setNumeroPresentation(numeroPresentation);
		
		Thread thread = new Thread(new Producteur(reponseSeConnecter));
		thread.start();
	}

	public String getMessageErreur() {
		return messageErreur;
	}

	public void setMessageErreur(String messageErreur) {
		this.messageErreur = messageErreur;
	}

	public Object getJoueurDTO() {
		return joueurDTO;
	}

	public void setJoueurDTO(Object joueurDTO) {
		this.joueurDTO = joueurDTO;
	}

	public int getNumeroPresentation() {
		return numeroPresentation;
	}

	public void setNumeroPresentation(int numeroPresentation) {
		this.numeroPresentation = numeroPresentation;
	}
}