package comportement.presentation2metier;

import activeMQ.Producteur;
import xml.presentation2metier.AuthentificationP2M;
import xml.presentation2metier.ObjectFactory;
import xml.presentation2metier.SeConnecterP2M;

public class SeConnecterP2MComportement{
	private String login;
	private String mdp;
	private int numeroPresentation;

	public SeConnecterP2MComportement(String login, String mdp, int numeroPresentation){
		this.login = login;
		this.mdp = mdp;
		this.numeroPresentation = numeroPresentation;
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
		seConnecter.setNumeroPresentation(numeroPresentation);
		
		new Producteur(seConnecter);		
	}

	public int getNumeroPresentation() {
		return numeroPresentation;
	}

	public void setNumeroPresentation(int numeroPresentation) {
		this.numeroPresentation = numeroPresentation;
	}
}