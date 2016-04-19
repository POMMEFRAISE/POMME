package comportement.metier2integration;

import activeMQ.Producteur;
import comportement.Commande;
import xml.metier2integration.AuthentificationM2I;
import xml.metier2integration.ObjectFactory;
import xml.metier2integration.SeConnecterM2I;

public class SeConnecterM2IComportement implements Commande{
	private String login;
	private String mdp;
	private String messageErreur;
	
	public SeConnecterM2IComportement(String login, String mdp){
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

	public String getMessageErreur() {
		return messageErreur;
	}

	public void setMessageErreur(String messageErreur) {
		this.messageErreur = messageErreur;
	}
	
	public void envoiMessage() {
		System.out.println("Login : "+login);
		System.out.println("MDP : "+mdp);

		if(login.equals("") || login == null || mdp.equals("") || mdp == null){
			messageErreur = "Tous les champs doivent être remplis";

		}
		ObjectFactory objFactory = new ObjectFactory();
		AuthentificationM2I authentificationM2I = objFactory.createAuthentificationM2I();
		authentificationM2I.setLoginAuthentification(login);
		authentificationM2I.setMdpAuthentification(mdp);
		authentificationM2I.setMessageErreur(messageErreur);
		SeConnecterM2I seConnecterM2I = objFactory.createSeConnecterM2I();
		seConnecterM2I.setAuthentification(authentificationM2I);
			
		new Producteur(seConnecterM2I);
	}
		
	public void reçoiMessage() {

	}
}