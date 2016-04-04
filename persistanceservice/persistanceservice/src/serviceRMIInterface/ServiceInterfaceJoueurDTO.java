package serviceRMIInterface;



import java.rmi.Remote;
import java.rmi.RemoteException;

import dto.JoueurDTO;

public interface ServiceInterfaceJoueurDTO extends Remote  {
	JoueurDTO recupererJoueur (Object joueurDTO) throws RemoteException  ;
	boolean verificationJoueur (Object joueurDTO) throws RemoteException;
	boolean demanderAuthentification() throws RemoteException;
}