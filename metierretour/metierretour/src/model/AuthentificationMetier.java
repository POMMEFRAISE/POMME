package model;

import java.io.Serializable;

public class AuthentificationMetier implements Serializable{
	private static final long serialVersionUID = 6648558566588800219L;
	private String idMessage;
	private String messageErreur;
	private JoueurMetier joueur;
	
	public AuthentificationMetier(JoueurMetier joueur, String idMessage, String messageErreur){
		this.idMessage = idMessage;
		this.messageErreur = messageErreur;
		this.joueur = joueur;
	}
	
	public AuthentificationMetier(String idMessage){
		this.idMessage = idMessage;
	}

	public String getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(String idMessage) {
		this.idMessage = idMessage;
	}

	public String getMessageErreur() {
		return messageErreur;
	}

	public void setMessageErreur(String messageErreur) {
		this.messageErreur = messageErreur;
	}

	public JoueurMetier getJoueur() {
		return joueur;
	}

	public void setJoueur(JoueurMetier joueur) {
		this.joueur = joueur;
	}
}