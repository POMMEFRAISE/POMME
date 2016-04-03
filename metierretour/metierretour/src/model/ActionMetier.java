package model;

import java.net.MalformedURLException;
import java.net.URL;

import activeMQ.Producteur;
import xml.metier2presentation.Authentification;
import xml.metier2presentation.Joueur;
import xml.metier2presentation.ObjectFactory;
import xml.metier2presentation.ReponseDemanderAuthentification;
import xml.metier2presentation.ReponseSeConnecter;



public class ActionMetier {
	private ObjectFactory objFactory;
	
	public ActionMetier(){
		objFactory = new ObjectFactory();
	}
	
	public void seConnecter(AuthentificationMetier auth){
		Joueur joueur = objFactory.createJoueur();
		joueur.setLoginJoueur(auth.getJoueur().getLoginJoueur());
		joueur.setNomJoueur(auth.getJoueur().getNomJoueur());
		joueur.setPrenomJoueur(auth.getJoueur().getPrenomJoueur());
		Authentification authenthentification = objFactory.createAuthentification();
		authenthentification.setJoueur(joueur);
		ReponseSeConnecter reponseSeConencter = objFactory.createReponseSeConnecter();
		reponseSeConencter.setAuthentification(authenthentification);
		
		new Producteur(reponseSeConencter, getURLProperties());
	}
	
	public void demanderAuthentification(AuthentificationMetier auth){
		ReponseDemanderAuthentification demandeAuthentification = objFactory.createReponseDemanderAuthentification();
		
		new Producteur(demandeAuthentification, getURLProperties());
	}
	
	public URL getURLProperties(){
		URL url = null;
		try {
			url = new URL(getClass().getProtectionDomain().getCodeSource().getLocation(),"configuration.properties");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return url;
	}
}