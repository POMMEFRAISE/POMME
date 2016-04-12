package model;

import java.io.IOException;
import java.io.StringReader;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

import filter.Filtre;
import xml.metier2presentation.ReponseDemanderAuthentification;
import xml.metier2presentation.ReponseSeConnecter;


public class ActionPresentation {
	private String message;
	private String idMessage;
	private Object typeMessage;
	private static String enTraitement = "oui";
	private static String pageRedirection;
	
	public ActionPresentation(String message, String idMessage){
		System.out.println("Action de présentation");
		this.message = message;
		this.setIdMessage(idMessage);
		getTypeMessage();
	}
	
	public void getTypeMessage(){
		typeMessage = unmarshaller(message);
        if(typeMessage instanceof ReponseDemanderAuthentification){
        	demanderAuthentification();
        }else if(typeMessage instanceof ReponseSeConnecter){
        	seConnecter();
        }
	}

	public void demanderAuthentification(){
		System.out.println("Demander Authentification Présentation");
		enTraitement = "non";
		pageRedirection = "connexion";
	}
	
	public void seConnecter(){
		Joueur joueur = new Joueur();
		joueur.setNom(((ReponseSeConnecter) typeMessage).getAuthentification().getJoueur().getNomJoueur());
    	joueur.setPrenom(((ReponseSeConnecter) typeMessage).getAuthentification().getJoueur().getPrenomJoueur());
    	joueur.setLogin(((ReponseSeConnecter) typeMessage).getAuthentification().getJoueur().getLoginJoueur());
    	if(joueur.getNom().equals("") && joueur.getPrenom().equals("") && joueur.getLogin().equals("")){
    		enTraitement = "non";
    		pageRedirection = "connexion";
    	}else{
    		enTraitement = "non";
    		pageRedirection = "accueil";
    	}
	}
	
	public Object unmarshaller(String message){
		Object object = null;
		Unmarshaller unmarshaller;
		JAXBContext context;
		StringReader reader;
		
		try {
			context = JAXBContext.newInstance(recupererValueProperty("XML_LECTEUR"));
			unmarshaller = context.createUnmarshaller();
			reader = new StringReader(message);
			object = unmarshaller.unmarshal(reader);
		} catch (PropertyException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return object;
	}
	
    public static String recupererValueProperty(String pro){
		//Permet de charger un fichier properties
    	ResourceBundle prop = ResourceBundle.getBundle("configuration");
		String value = prop.getString(pro);
		return value;
    }

	public String getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(String idMessage) {
		this.idMessage = idMessage;
	}

	public static String getPageRedirection() {
		return pageRedirection;
	}

	public static void setPageRedirection(String pageRedirection) {
		ActionPresentation.pageRedirection = pageRedirection;
	}

	public static String getEnTraitement() {
		return enTraitement;
	}

	public static void setEnTraitement(String enTraitement) {
		ActionPresentation.enTraitement = enTraitement;
	}
}