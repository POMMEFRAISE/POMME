package model;

import java.io.StringReader;
import java.util.ResourceBundle;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

import xml.metier2presentation.ReponseDemanderAuthentification;
import xml.metier2presentation.ReponseSeConnecter;


public class ActionPresentation {
	private String message;
	private String idMessage;
	private Object typeMessage;
	public ActionPresentation(String message, String idMessage){
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

	public boolean demanderAuthentification(){
		return true;	
	}
	
	public boolean seConnecter(){
		Joueur joueur = new Joueur();
		joueur.setNom(((ReponseSeConnecter) typeMessage).getAuthentification().getJoueur().getNomJoueur());
    	joueur.setPrenom(((ReponseSeConnecter) typeMessage).getAuthentification().getJoueur().getPrenomJoueur());
    	joueur.setLogin(((ReponseSeConnecter) typeMessage).getAuthentification().getJoueur().getLoginJoueur());
    	if(joueur.getNom().equals("") && joueur.getPrenom().equals("") && joueur.getLogin().equals("")){
    		return false;
    	}else{
    		return true;
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
}