package servicermiinterface;



import java.rmi.Remote;
import java.rmi.RemoteException;

import dto.JoueurDTO;

public interface ServiceJoueurInterface extends Remote  {
	JoueurDTO recupererJoueur (Object joueurDTO) throws RemoteException  ;
	boolean verifierJoueur (Object joueurDTO) throws RemoteException;
	JoueurDTO creerCompte (Object joueurDTO) throws RemoteException;
	JoueurDTO gererProfil (Object joueurDTO) throws RemoteException;
	
}