package serveurRMI;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMIClassLoader;
import java.util.Properties;
public class Serveur {
	public static void main(String[] args) {
		if (System.getSecurityManager() == null) 
			System.setProperty("java.security.policy", "file:/C:/Users/Dylan/git/PDS/persistanceserveur/persistanceserveur/bin/serveurRMI/server.policy");
			//System.setProperty("java.rmi.server.codebase", "file:/C:/Users/Dylan/git/PDS/persistanceservice/persistanceservice/bin/");
			System.setSecurityManager(new SecurityManager());
		try {
			//Class<?> ServiceJoueurDTO = RMIClassLoader.loadClass("file:/C:/Users/Cyrielle/Desktop/bin/","serviceRMIImplementation.ServiceJoueurDTO");
			//Class<?> ServiceJoueurDTO = RMIClassLoader.loadClass("file:/C:/Users/Dylan/git/PDS/persistanceservice/persistanceservice/bin/serviceRMIImplementation","serviceRMIImplementation.ServiceJoueurDTO");
			//System.out.println("Serveur Bonjour "+ ServiceJoueurDTO.getName());
			//Object o = ServiceJoueurDTO.newInstance();
			//Registry registry = LocateRegistry.createRegistry(1099);
			//registry.rebind("//127.0.0.1/ServiceJoueurDTO",(Remote) ServiceJoueurDTO.newInstance());
			
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
	
	

