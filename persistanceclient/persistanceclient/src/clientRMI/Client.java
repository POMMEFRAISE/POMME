package clientRMI;

import java.lang.reflect.Constructor;
import java.net.MalformedURLException;
import java.rmi.server.RMIClassLoader;


public class Client {
	public static void main(String[] argv) throws Exception {
    	if (System.getSecurityManager() == null) 
			System.setProperty("java.security.policy", "file:/C:/Users/Cyrielle/git/PDS/persistanceclient/persistanceclient/bin/client.policy");
			System.setSecurityManager(new SecurityManager());
			
			try {
				//Appelle de la classe JoueurDTO
				String url="file:/C:/Users/Cyrielle/git/PDS/persistanceservice/persistanceservice/bin/";
				Class<?> joueurDTO = RMIClassLoader.loadClass(url,"dto.JoueurDTO");
				Object objectJoueurDTO = joueurDTO.newInstance();
				System.out.println(objectJoueurDTO);
				
				
				Class<?> serviceRMIInterface = RMIClassLoader.loadClass(url,"serviceClient.ServiceClient");
				Constructor<?> c = serviceRMIInterface.getConstructor();
				c.newInstance();
				
				
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
			
	
}
