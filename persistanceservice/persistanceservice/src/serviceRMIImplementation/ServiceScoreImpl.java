package serviceRMIImplementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import daoImplementation.DaoScoreImpl;
import daoInterface.DaoScoreInterface;
import serviceRMIInterface.ServiceScoreInterface;

public class ServiceScoreImpl extends UnicastRemoteObject implements ServiceScoreInterface {

	private DaoScoreInterface daoScoreInterface;
	private static final long serialVersionUID = 1L;

	protected ServiceScoreImpl() throws RemoteException {
		daoScoreInterface = new DaoScoreImpl();
	}

}
