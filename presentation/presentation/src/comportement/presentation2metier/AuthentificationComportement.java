package comportement.presentation2metier;

import java.io.Serializable;

import activeMQ.Producteur;
import comportement.Commande;
import xml.presentation2metier.Authentification;
import xml.presentation2metier.ObjectFactory;
import xml.presentation2metier.SeConnecter;

public class AuthentificationComportement implements Serializable, Commande{
	private static final long serialVersionUID = 6648558566588800219L;
	private String login;
	private String mdp;
	
	public AuthentificationComportement(String login, String mdp){
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

	public void envoiMessage() {
		ObjectFactory objFactory = new ObjectFactory();

	    Authentification authentification = objFactory.createAuthentification();
	    authentification.setLoginAuthentification(login);
	    authentification.setMdpAuthentification(mdp);
	    
		SeConnecter seConnecter = objFactory.createSeConnecter();
		seConnecter.setAuthentification(authentification);
		
		new Producteur(seConnecter);		
	}

	public String reçoiMessage() {
		return "";
	}
}