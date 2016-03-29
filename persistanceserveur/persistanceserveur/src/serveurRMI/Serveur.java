package serveurRMI;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.server.RMIClassLoader;
public class Serveur {
	public static void main(String[] args) {
		if (System.getSecurityManager() == null) 
			System.setSecurityManager(new SecurityManager());
		try {
			Class<?> ServiceJoueurDTO = RMIClassLoader.loadClass("file:/C:/Users/Cyrielle/Desktop/bin/","serviceRMIImplementation.ServiceJoueurDTO");
			System.out.println("Serveur Bonjour "+ ServiceJoueurDTO.getName());
			Object o = ServiceJoueurDTO.newInstance();
			Naming.rebind("rmi://10.0.2.15/ServiceJoueurDTO",(Remote) o);
			System.out.println("Serveur Bonjour");
		}catch (Exception e) {
			System.out.println("Erreur de liaison de l'objet ServiceDTO");
			e.printStackTrace();
		}
	} 
} 
	
	

