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
import dto.JoueurDTO;
import serviceRMI.ServiceRMIInterface;
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
		System.out.println("Bonjour");
		run();
	}
	
/*	public ClientRMI() {

	}*/

	// Methode Run

	public void run() {	
		try {
			
			
			Class<JoueurDTO> maClass = (Class<JoueurDTO>) telechargerClasse("dto.JoueurDTO");
			System.out.println("Ma Classe :"+maClass.getTypeName());			
			JoueurDTO joueurDTO = maClass.newInstance();
			System.out.println(joueurDTO.getClass());
			System.out.println("joueurDTO login:"+joueurDTO.getLogin());

			try {		
				if (System.getSecurityManager() == null) 
					System.setSecurityManager(new SecurityManager());
				//System.setProperty("java.rmi.server.codebase", "http://127.0.0.1:80/persistanceservice.jar");
				Class maClass2 = telechargerClasse("serviceRMI.ServiceRMIInterface");
				ServiceRMIInterface serviceRmi = (ServiceRMIInterface) maClass2.newInstance();
				serviceRmi = (ServiceRMIInterface) Naming.lookup ("//127.0.0.1/ServiceRMIExporte");

				Object typeMessage;
		        typeMessage = unmarshaller(message);
		        if(typeMessage instanceof DemanderAuthentification){
		    		System.out.println("DemanderAuthentification");
					boolean trouve = serviceRmi.demanderAuthentification();
					System.out.println("DemanderAuthentification : "+trouve);
		        }else if(typeMessage instanceof SeConnecter){
					((JoueurDTO) joueurDTO).setLogin(((SeConnecter) typeMessage).getAuthentification().getLoginAuthentification());
					((JoueurDTO) joueurDTO).setMotDePasse(((SeConnecter) typeMessage).getAuthentification().getMdpAuthentification());
					
		        	boolean trouveJoueur = serviceRmi.verificationJoueur((JoueurDTO) joueurDTO);
					System.out.println("SeConnecter : "+trouveJoueur);
					if(trouveJoueur == true){
						joueurDTO = serviceRmi.recupererJoueur((JoueurDTO) joueurDTO);
						System.out.println("Nom joueur : "+((JoueurDTO) joueurDTO).getNom());
						Joueur joueur = objFactory.createJoueur();
						joueur.setLoginJoueur(((JoueurDTO) joueurDTO).getLogin());
						joueur.setNomJoueur(((JoueurDTO) joueurDTO).getNom());
						joueur.setPrenomJoueur(((JoueurDTO) joueurDTO).getPrenom());
						Authentification auth = objFactory.createAuthentification();
						auth.setJoueur(joueur);
						ReponseSeConnecter reponseSeConencter = objFactory.createReponseSeConnecter();
						reponseSeConencter.setAuthentification(auth);
						new Producteur(reponseSeConencter);
					}
		        }
				
				
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (NotBoundException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
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
    
    //Permet de charger une classe 
    public Class<?> telechargerClasse(String maClasse){
		Class<?> classeACharger = null;

    	try {
    		URL[] urls = {new URL("http://127.0.0.1:80/persistanceservice.jar")};
    		URLClassLoader urlClassLoader = URLClassLoader.newInstance(urls);				
			classeACharger = Class.forName(maClasse, true, urlClassLoader);
			System.out.println("Classe Instancier : "+classeACharger);
			//Ligne a supprimer?
			//urlClassLoader.close();			
		} catch (MalformedURLException e) {
			System.out.println("Jar non chargé");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Jar non chargé");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return classeACharger;
    }
}