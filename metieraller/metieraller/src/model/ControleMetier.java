package model;

import java.net.MalformedURLException;
import java.net.URL;

import activeMQ.Producteur;
import xml.metier2integration.Authentification;
import xml.metier2integration.DemanderAuthentification;
import xml.metier2integration.ObjectFactory;
import xml.metier2integration.SeConnecter;

public class ControleMetier {
	private ObjectFactory objFactory;
	
	public ControleMetier(){
		objFactory = new ObjectFactory();
	}
	
	public void seConnecter(AuthentificationMetier auth){
		System.out.println("Login : "+auth.getLogin());
		System.out.println("MDP : "+auth.getMdp());

		if(auth.getLogin().equals("") || auth.getLogin() == null || auth.getMdp().equals("") || auth.getMdp() == null){
			auth.setMessageErreur("Tous les champs doivent être remplis");
			ActionMetier actionMetier = new ActionMetier();
			actionMetier.seConnecter(auth);
			//Créer nouvelle file message et changer bean 
			//Retour c soit joueur soit authentification de aller si erreurs
		}else{
			Authentification authentification = objFactory.createAuthentification();
			authentification.setLoginAuthentification(auth.getLogin());
			authentification.setMdpAuthentification(auth.getMdp());
			SeConnecter seConnecter = objFactory.createSeConnecter();
			seConnecter.setAuthentification(authentification);
			
			new Producteur(seConnecter, getURLProperties());
		}
	}
	
	public void demanderAuthentification(AuthentificationMetier auth){
		DemanderAuthentification demandeAuthentification = objFactory.createDemanderAuthentification();
		
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