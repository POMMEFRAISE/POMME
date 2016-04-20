package servicermiinterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceCommandeInterface extends Remote {
	boolean demanderAuthentification (Object message) throws RemoteException;

}
