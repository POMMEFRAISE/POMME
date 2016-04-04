package clientRMI;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.server.RMIClassLoader;



public class Client {
	public static void main(String[] argv) throws Exception {
		if (System.getSecurityManager() == null) 
			System.setProperty("java.security.policy", "file:/C:/Users/Dylan/git/PDS/persistanceclient/persistanceclient/bin/clientRMI/client.policy");
			System.setSecurityManager(new SecurityManager());
			
				//url
				String url="file:/C:/Users/Dylan/git/PDS/persistanceservice/persistanceservice/bin/";
				
				//Appelle de la classe JoueurDTO
				Class<?> serviceJoueur = RMIClassLoader.loadClass(url,"serviceFacade.ServiceFacade");
				Object serviceJoueurDTO = serviceJoueur.newInstance();
				System.out.println(serviceJoueurDTO.getClass());
				Method methode = serviceJoueur.getMethod("getServiceJoueurDTO");
				//System.out.println(serviceJoueurDTO.getClass().getDeclaredMethod("getServiceJoueurDTO").invoke(serviceJoueurDTO));
				System.out.println(methode.getReturnType());
				Remote method = (Remote)Naming.lookup("//127.0.0.1/ServiceJoueurDTO");
				
	}
		
}