package clientRMI;

import java.lang.reflect.Constructor;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.server.RMIClassLoader;



public class Client {
	public static void main(String[] argv) throws Exception {
		if (System.getSecurityManager() == null) 
			System.setProperty("java.security.policy", "file:/C:/Users/Cyrielle/git/PDS/persistanceclient/persistanceclient/bin/clientRMI/client.policy");
			System.setSecurityManager(new SecurityManager());
			
				//url
				String url="file:/C:/Users/Cyrielle/git/PDS/persistanceservice/persistanceservice/bin/";
				
				//Appelle de la classe JoueurDTO
				Class<?> serviceJoueur = RMIClassLoader.loadClass(url,"serviceFacade.ServiceFacade");
				Object serviceJoueurDTO = serviceJoueur.newInstance();
				serviceJoueurDTO = serviceJoueurDTO.getClass().getDeclaredMethod("getServiceJoueurDTO", null).invoke(serviceJoueurDTO, null);
				serviceJoueurDTO = Naming.lookup("//127.0.0.1/ServiceJoueurDTO");
				System.out.println(serviceJoueurDTO);
				
	}
		
}
