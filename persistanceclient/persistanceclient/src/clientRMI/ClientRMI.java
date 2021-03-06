package clientRMI;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import comportement.Commande;
import util.JAXB;

public class ClientRMI extends Thread {
	private String idMessage;
	private String message;
	public ClientRMI(String idMessage, String message) {
		this.idMessage = idMessage;
		this.message = message;
		run();
	}

	public void run() {	
		//Policy
		if (System.getSecurityManager() == null) {
			System.setProperty("java.security.policy", "file:/C:/Users/Dylan/git/PDS/persistanceclient/persistanceclient/bin/clientRMI/client.policy");
			System.setProperty("java.rmi.server.codebase", "file:/C:/Users/Dylan/git/PDS/persistanceservice/persistanceservice/bin/");
			//System.setProperty("java.security.policy", "http://localhost/clientrmi/client.policy");
			//System.setProperty("java.rmi.server.codebase", "http://localhost/servicermi/persistanceservice.jar");
			System.setSecurityManager(new SecurityManager());
		}
		
		try {
			Naming.lookup("//127.0.0.1/ServiceJoueur");
			Naming.lookup("//127.0.0.1/ServicePartie");
			Naming.lookup("//127.0.0.1/ServiceCommande");
			convertirMessageObjet(message);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}	
	}
			
	public void convertirMessageObjet(String message){
		Object typeMessage = JAXB.unmarshaller(message);
        String messageClasse = typeMessage.getClass().getSimpleName();
        Class<?> messageComportement;
		try {
			messageComportement = Class.forName("comportement.metier2integration."+messageClasse+"Comportement");
	        Constructor<?>[] constructors = messageComportement.getConstructors();
	        Commande commande = (Commande) constructors[0].newInstance(typeMessage);
	        commande.reçoiMessage();
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
}