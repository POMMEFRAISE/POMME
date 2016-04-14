package model;

import java.io.StringReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

import comportement.Commande;
import util.RecupererValueProperty;

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
		Object typeMessage = unmarshaller(message);
        String messageClasse = typeMessage.getClass().getSimpleName();
        Class<?> messageComportement;
		try {
			messageComportement = Class.forName("comportement.metier2presentation."+messageClasse+"Comportement");
	        Constructor<?>[] constructors = messageComportement.getConstructors();
	        Commande commande = (Commande) constructors[0].newInstance(typeMessage);
	        redirection = commande.reçoiMessage();
	        System.out.println("Action Presentation : redirection : "+redirection);
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
	
	public Object unmarshaller(String message){
		Object object = null;
		Unmarshaller unmarshaller;
		JAXBContext context;
		StringReader reader;
		
		try {
			context = JAXBContext.newInstance(RecupererValueProperty.recupererValueProperty("XML_LECTEUR"));
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