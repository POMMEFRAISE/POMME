package serviceRMIInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface  ServicePartieInterface extends Remote {
	boolean rejoindrePartie(Object nompartie, Object nbrejoueur) throws RemoteException ;

}
