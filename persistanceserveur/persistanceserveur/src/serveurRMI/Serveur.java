package serveurRMI;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMIClassLoader;
import java.util.Properties;

import serviceRMIImplementation.ServiceJoueurDTO;

public class Serveur {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		System.setSecurityManager(new RMISecurityManager());
		try {
			Properties p= System.getProperties();
			String url=p.getProperty("java.rmi.server.codebase"); 
			Class ClasseServeur = RMIClassLoader.loadClass(url,"ServiceJoueurDTO"); 
			Naming.rebind("rmi://localhost:1099/ServiceJoueurDTO",(Remote)ClasseServeur.newInstance());
			System.out.println("Objet Service dans le RMIregistry");
			System.out.println("Attente des invocations des clients ...");
		}catch (Exception e) {
			System.out.println("Erreur de liaison de l'objet Reverse");
			System.out.println(e.toString());
		}
	} 
} 
	
	


}
