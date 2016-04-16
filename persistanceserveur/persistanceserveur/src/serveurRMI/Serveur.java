package serveurRMI;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMIClassLoader;
public class Serveur {
	public static void main(String[] args) {
		if (System.getSecurityManager() == null) 
			System.setProperty("java.security.policy", "file:/C:/Users/Cyrielle/git/PDS/persistanceserveur/persistanceserveur/bin/serveurRMI/server.policy");
			System.setProperty("java.rmi.server.codebase", "file:/C:/Users/Cyrielle/git/PDS/persistanceservice/persistanceservice/bin/");
			System.setSecurityManager(new SecurityManager());
		try {
			Registry registry = LocateRegistry.createRegistry(1099);
			String url="file:/C:/Users/Cyrielle/git/PDS/persistanceservice/persistanceservice/bin/";
			Class<?> serviceJoueur = RMIClassLoader.loadClass(url,"serviceRMIImplementation.ServiceJoueurImpl");
			registry.rebind("ServiceJoueur",(Remote)serviceJoueur.newInstance());
			System.out.println("Serveur Bonjour");
		}catch (Exception e) {
			System.out.println("Erreur de liaison de l'objet ServiceDTO");
			e.printStackTrace();
		}
	} 
} 
	
	

