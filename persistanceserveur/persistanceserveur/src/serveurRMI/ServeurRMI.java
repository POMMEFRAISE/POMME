package serveurRMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import serviceRMI.ServiceRMI;


public class ServeurRMI {	
	public static void main (String[] argv) {
		try {	
			//Mise en place d'un registre RMI
			Registry r = LocateRegistry.createRegistry(1099);

			r.rebind("ServiceRMI", new ServiceRMI());
			System.out.println("Serveur lancé");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}