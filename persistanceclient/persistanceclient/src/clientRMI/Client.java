package clientRMI;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMIClassLoader;

public class Client {
	public static void main(String[] argv) throws Exception {
		if (System.getSecurityManager() == null) {
			System.setProperty("java.security.policy", "file:/C:/Users/Dylan/git/PDS/persistanceclient/persistanceclient/bin/clientRMI/client.policy");
			System.setProperty("java.rmi.server.codebase", "file:/C:/Users/Dylan/git/PDS/persistanceservice/persistanceservice/bin/");
			System.setSecurityManager(new SecurityManager());
	}
	//		Registry r = LocateRegistry.getRegistry("localhost", 1099);
		//	String[] services = r.list();
			//for (String sName : services)
				//System.out.println("service: " + sName);
				//url
				String url="file:/C:/Users/Dylan/git/PDS/persistanceservice/persistanceservice/bin/";
				
				//Appelle de la classe JoueurDTO
				Class<?> serviceJoueur = RMIClassLoader.loadClass(url,"serviceFacade.ServiceFacade");
				Object serviceJoueurDTO = serviceJoueur.newInstance();
				serviceJoueurDTO = serviceJoueurDTO.getClass().getMethod("getServiceJoueurDTO");
				System.out.println(serviceJoueurDTO);
				Remote rem = Naming.lookup("//127.0.0.1/ServiceJoueurDTO");
	}

}