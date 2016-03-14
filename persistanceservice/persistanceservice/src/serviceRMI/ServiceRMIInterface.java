package serviceRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dto.JoueurDTO;

public interface ServiceRMIInterface extends Remote{
	JoueurDTO recupererJoueur (JoueurDTO joueurDTO) throws RemoteException ;
	boolean verificationJoueur (JoueurDTO joueurDTO) throws RemoteException;
	boolean rejoindrePartie(String nompartie, int nbrejoueur) throws RemoteException;
	boolean demanderAuthentification() throws RemoteException;
}