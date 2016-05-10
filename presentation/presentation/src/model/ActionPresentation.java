package model;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import comportement.Commande;
import util.JAXB;

public class ActionPresentation {
	private String message;
	private Object objetARetourner;
	
	public ActionPresentation(){
	}
	
	public void convertirMessageObjet(){
		Object typeMessage = JAXB.unmarshaller(message);
        String messageClasse = typeMessage.getClass().getSimpleName();
        Class<?> messageComportement;
		try {
			messageComportement = Class.forName("comportement.metier2presentation."+messageClasse+"Comportement");
	        Constructor<?>[] constructors = messageComportement.getConstructors();
	        Commande commande = (Commande) constructors[0].newInstance(typeMessage);
	        objetARetourner = commande.reçoiMessage();
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
	
	public Object getObjetARetourner() {
		return objetARetourner;
	}

	public void setObjetARetourner(Object objetARetourner) {
		this.objetARetourner = objetARetourner;
	}
}