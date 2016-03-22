package clientRMI;

import java.rmi.server.RMIClassLoader;

public class Client {
    @SuppressWarnings("rawtypes")
	public static void main(String[] argv) throws Exception {
    	Class noparams[] = {};
    	Class[] paramString = new Class[1];	
    	paramString[0] = String.class;
        Class ClasseServeur = RMIClassLoader.loadClass("http://127.0.0.1:80/persistanceservice.jar", "JoueurDTO");
       
        
    }  
    
	
}
