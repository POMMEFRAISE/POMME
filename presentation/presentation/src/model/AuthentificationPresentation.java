package model;

import java.io.Serializable;

public class AuthentificationPresentation implements Serializable{
	private static final long serialVersionUID = 6648558566588800219L;
	private String login;
	private String mdp;
	
	public AuthentificationPresentation(String login, String mdp){
		this.login = login;
		this.mdp = mdp;
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
}