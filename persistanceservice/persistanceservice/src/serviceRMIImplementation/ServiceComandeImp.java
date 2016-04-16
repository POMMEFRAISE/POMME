package serviceRMIImplementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import daoImplementation.DaoComandeImpl;
import daoInterface.DaoComandeInterface;
import serviceRMIInterface.ServiceComandeInterface;

public class ServiceComandeImp extends UnicastRemoteObject implements ServiceComandeInterface{

	private static final long serialVersionUID = 1L;
	private DaoComandeInterface daoComandeInterface;
	protected ServiceComandeImp() throws RemoteException {
		daoComandeInterface = new DaoComandeImpl();
	}



}
