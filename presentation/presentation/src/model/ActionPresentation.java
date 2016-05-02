package model;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import comportement.Commande;
import util.JAXB;

//VOIR SI ON PEUT LA METTRE DANS LE JAR UTIL AVEC DANS FICHIER DE CONFIGURATION LE PACKAGE CONCERNER PAR LES CLASSES COMPORTEMENTS
//CONCERNE JUSTE LE RETOUR
//METRE INTERFACE COMMANDE DANS LE JAR AUSSI
public class ActionPresentation {
	private String message;
	private String idMessage;
	private String redirection;
	
	public ActionPresentation(String message, String idMessage){
		System.out.println("Action de présentation");
		this.message = message;
		this.setIdMessage(idMessage);
		convertirMessageObjet();
	}
	
	public void convertirMessageObjet(){
		Object typeMessage = JAXB.unmarshaller(message);
        String messageClasse = typeMessage.getClass().getSimpleName();
        Class<?> messageComportement;
		try {
			messageComportement = Class.forName("comportement.metier2presentation."+messageClasse+"Comportement");
	        Constructor<?>[] constructors = messageComportement.getConstructors();
	        Commande commande = (Commande) constructors[0].newInstance(typeMessage);
	        redirection = commande.reçoiMessage();
	        System.out.println("Redirection Action Presentation : "+redirection);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(String idMessage) {
		this.idMessage = idMessage;
	}

	public String getRedirection() {
		return redirection;
	}

	public void setRedirection(String redirection) {
		this.redirection = redirection;
	}
}