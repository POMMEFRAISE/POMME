package servicermiinterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceCommandeInterface extends Remote {
	boolean enregistrerCommande (Object message) throws RemoteException;
	Object afficherCommande() throws RemoteException;
}