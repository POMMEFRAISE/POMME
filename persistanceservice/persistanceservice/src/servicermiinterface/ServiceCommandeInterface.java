package servicermiinterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceCommandeInterface extends Remote {
	boolean enregistrerCommande (Object commandeDTO) throws RemoteException;
	Object afficherCommande() throws RemoteException;
	int demanderNumeroPresentation() throws RemoteException;
}