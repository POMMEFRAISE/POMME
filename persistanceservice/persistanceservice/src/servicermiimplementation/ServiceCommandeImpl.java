package servicermiimplementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import daoimplementation.DaoScoreImpl;
import daointerface.DaoCommandeInterface;
import servicermiinterface.ServiceCommandeInterface;

public class ServiceCommandeImpl extends UnicastRemoteObject implements ServiceCommandeInterface{

	private static final long serialVersionUID = 1L;
	private DaoCommandeInterface daoComandeInterface;
	public ServiceCommandeImpl() throws RemoteException {
		daoComandeInterface = new DaoScoreImpl();
	}
	@Override
	public boolean demanderAuthentification(Object message) throws RemoteException {
		boolean enregistrer = false; 
		if (daoComandeInterface.demanderAuthentification((String) message) == true){
			enregistrer = true;
		}
		return enregistrer;
	}



}
