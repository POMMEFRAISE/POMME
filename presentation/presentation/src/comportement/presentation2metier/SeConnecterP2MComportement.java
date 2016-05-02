package comportement.presentation2metier;

import activeMQ.Producteur;
import xml.presentation2metier.AuthentificationP2M;
import xml.presentation2metier.ObjectFactory;
import xml.presentation2metier.SeConnecterP2M;

public class SeConnecterP2MComportement{
	private String login;
	private String mdp;
	
	public SeConnecterP2MComportement(String login, String mdp){
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
		System.out.println("SeConnecterP2MComportement : login : "+login);
		ObjectFactory objFactory = new ObjectFactory();

	    AuthentificationP2M authentification = objFactory.createAuthentificationP2M();
	    authentification.setLoginAuthentification(login);
	    authentification.setMdpAuthentification(mdp);
	    
		SeConnecterP2M seConnecter = objFactory.createSeConnecterP2M();
		seConnecter.setAuthentification(authentification);
		
		new Producteur(seConnecter);		
	}
}