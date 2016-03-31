package clientRMI;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMIClassLoader;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

import com.sun.webkit.plugin.Plugin;

import activeMQ.Producteur;
import xml.integration2metier.Authentification;
import xml.integration2metier.Joueur;
import xml.integration2metier.ObjectFactory;
import xml.integration2metier.ReponseSeConnecter;
import xml.metier2integration.DemanderAuthentification;
import xml.metier2integration.SeConnecter;

public class ClientRMI extends Thread {
	public String serviceName;
	public Object objetDTO;
	public String commande;
	private String message;
	private String idMessage;
	private ObjectFactory objFactory = new ObjectFactory();

	public ClientRMI(String message, String idMessage) {
		this.message = message;
		this.idMessage = idMessage;
		run();
	}


	// Methode Run

	public void run() {	
		
		//Policy
		if (System.getSecurityManager() == null) 
			System.setProperty("java.security.policy", "file:/C:/Users/Cyrielle/git/PDS/persistanceclient/persistanceclient/bin/clientRMI/client.policy");
			System.setSecurityManager(new SecurityManager());
			try {
				//url
				String url="file:/C:/Users/Cyrielle/git/PDS/persistanceservice/persistanceservice/bin/";
				//Appelle de la classe JoueurDTO
				Class<?> joueurDTO = RMIClassLoader.loadClass(url,"dto.JoueurDTO");
				Object objectJoueurDTO = joueurDTO.newInstance();
				
				
				//Charger interface 
				
				
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
}