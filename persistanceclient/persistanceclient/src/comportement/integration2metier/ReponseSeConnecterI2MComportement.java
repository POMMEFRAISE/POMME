package comportement.integration2metier;

import java.lang.reflect.InvocationTargetException;

import activeMQ.Producteur;
import comportement.Commande;
import xml.integration2metier.AuthentificationI2M;
import xml.integration2metier.JoueurI2M;
import xml.integration2metier.ObjectFactory;
import xml.integration2metier.ReponseSeConnecterI2M;

public class ReponseSeConnecterI2MComportement implements Commande{
	private String messageErreur;
	private Object joueurDTO;
	public ReponseSeConnecterI2MComportement(String messageErreur, Object joueurDTO){
		this.messageErreur = messageErreur;	
		this.joueurDTO = joueurDTO;
	}
	
	public void reçoiMessage() {

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
		ReponseSeConnecterI2M reponseSeConencter = objFactory.createReponseSeConnecterI2M();
		reponseSeConencter.setAuthentification(authentification);
		
		new Producteur(reponseSeConencter);
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
}