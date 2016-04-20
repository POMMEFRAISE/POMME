package servicermiimplementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import daoimplementation.DaoComandeImpl;
import daointerface.DaoComandeInterface;
import servicermiinterface.ServiceCommandeInterface;

public class ServiceCommandeImpl extends UnicastRemoteObject implements ServiceCommandeInterface{

	private static final long serialVersionUID = 1L;
	private DaoComandeInterface daoComandeInterface;
	public ServiceCommandeImpl() throws RemoteException {
		daoComandeInterface = new DaoComandeImpl();
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
