package model;

import java.io.Serializable;

public class AuthentificationMetier implements Serializable{
	private static final long serialVersionUID = 6648558566588800219L;
	private String login;
	private String mdp;
	private String idMessage;
	private String messageErreur;
	
	public AuthentificationMetier(String login, String mdp, String idMessage){
		this.login = login;
		this.mdp = mdp;
		this.idMessage = idMessage;
		this.messageErreur = "";
	}
	
	public AuthentificationMetier(String idMessage){
		this.idMessage = idMessage;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getMdp() {
		return mdp;
	}
	
	public void setMdp(String mdp) {
		this.mdp = mdp;
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
}