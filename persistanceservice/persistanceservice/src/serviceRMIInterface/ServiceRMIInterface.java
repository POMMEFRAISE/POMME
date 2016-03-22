package serviceRMIInterface;



import java.rmi.Remote;
import java.rmi.RemoteException;

import dto.JoueurDTO;

public interface ServiceRMIInterface extends Remote  {
	JoueurDTO recupererJoueur (JoueurDTO joueurDTO) throws RemoteException  ;
	boolean verificationJoueur (Object joueurDTO) throws RemoteException;
	boolean demanderAuthentification() throws RemoteException;
}