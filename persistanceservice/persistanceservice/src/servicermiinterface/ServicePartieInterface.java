package servicermiinterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dto.PartieDTO;

public interface  ServicePartieInterface extends Remote {
	
	PartieDTO recupererPartie (Object partieDTO) throws RemoteException ;
	PartieDTO creerPartie (Object partieDTO) throws RemoteException ;
	boolean rejoindrePartie(Object partieDTO) throws RemoteException ;
	Object afficherEtatPartie (Object nompartie) throws RemoteException ;
	boolean fermerPartie (Object partieDTO) throws RemoteException ; 
	boolean verifierPartie (Object partieDTO) throws RemoteException;


}
