package servicermiimplementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import daoimplementation.DaoCommandeImpl;
import daointerface.DaoCommandeInterface;
import servicermiinterface.ServiceCommandeInterface;

public class ServiceCommandeImpl extends UnicastRemoteObject implements ServiceCommandeInterface{

	private static final long serialVersionUID = 1L;
	private DaoCommandeInterface daoComandeInterface;
	
	public ServiceCommandeImpl() throws RemoteException {
		daoComandeInterface = new DaoCommandeImpl();
	}
	
	@Override
	public boolean enregistrerCommande(Object message) throws RemoteException {
		boolean enregistrer = false; 
		if (daoComandeInterface.enregistrerCommande((String) message) == true){
			enregistrer = true;
		}
		return enregistrer;
	}

	@Override
	public Object afficherCommande() throws RemoteException {

		return null;
	}	
}