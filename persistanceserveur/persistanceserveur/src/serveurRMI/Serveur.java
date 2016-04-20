package serveurRMI;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMIClassLoader;
public class Serveur {
	public static void main(String[] args) {
		if (System.getSecurityManager() == null) 
			System.setProperty("java.security.policy", "file:C:/Users/Cyrielle/Desktop/ServeurRMI/src/serveurrmi/server.policy");
			System.setProperty("java.rmi.server.codebase", "file:/C:/Users/Cyrielle/git/PDS/persistanceservice/persistanceservice/bin/");
			System.setSecurityManager(new SecurityManager());
		try {
			Registry registry = LocateRegistry.createRegistry(1099);
			String url="file:/C:/Users/Cyrielle/git/PDS/persistanceservice/persistanceservice/bin/";
			Class<?> serviceJoueur = RMIClassLoader.loadClass(url,"servicermiimplementation.ServiceJoueurImpl");
			Class<?> servicePartie = RMIClassLoader.loadClass(url,"servicermiimplementation.ServicePartieImpl");
			Class<?> serviceCommande = RMIClassLoader.loadClass(url,"servicermiimplementation.ServiceCommandeImpl");
			registry.rebind("ServiceJoueur",(Remote)serviceJoueur.newInstance());
			registry.rebind("ServicePartie",(Remote)servicePartie.newInstance());
			registry.rebind("ServiceCommande",(Remote)serviceCommande.newInstance());
		}catch (Exception e) {
			System.out.println("Erreur de liaison de l'objet ServiceDTO");
			e.printStackTrace();
		}
	} 
} 
	
	

