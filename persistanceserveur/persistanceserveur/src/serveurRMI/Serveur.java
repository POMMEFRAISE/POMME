package serveurRMI;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMIClassLoader;
public class Serveur {
	public static void main(String[] args) {
		if (System.getSecurityManager() == null) 
			System.setProperty("java.security.policy", "file:/C:/Users/Dylan/git/PDS/persistanceserveur/persistanceserveur/bin/serveurRMI/server.policy");
			System.setProperty("java.rmi.server.codebase", "file:/C:/Users/Dylan/git/PDS/persistanceservice/persistanceservice/bin/");
			System.setSecurityManager(new SecurityManager());
		try {
			Registry registry = LocateRegistry.createRegistry(1099);
			String url="file:/C:/Users/Dylan/git/PDS/persistanceservice/persistanceservice/bin/";
			Class<?> serviceJoueurDTO = RMIClassLoader.loadClass(url,"serviceRMIImplementation.ServiceJoueurDTO");
			registry.rebind("ServiceJoueurDTO",(Remote)serviceJoueurDTO.newInstance());
			System.out.println("Serveur Bonjour");
		}catch (Exception e) {
			System.out.println("Erreur de liaison de l'objet ServiceDTO");
			e.printStackTrace();
		}
	} 
} 
	
	

