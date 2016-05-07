package servicermiinterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dto.JeuxDTO;
import dto.PartieDTO;
import dto.PartiesDTO;

public interface  ServicePartieInterface extends Remote {
	PartieDTO recupererPartie (Object partieDTO) throws RemoteException ;
	boolean creerPartie (Object partieDTO) throws RemoteException ;
	boolean rejoindrePartie(Object partieDTO, Object joueurDTO, Integer numeroPresentation) throws RemoteException ;
	Object afficherEtatPartie (Object nompartie) throws RemoteException ;
	boolean fermerPartie () throws RemoteException ; 
	boolean verifierPartie (Object partieDTO) throws RemoteException ;
	PartiesDTO recupererListeParties () throws RemoteException ;
	PartiesDTO recupererListePartiesPourChangerEtat () throws RemoteException ;
	boolean verifierPartieRejoindre (Object partieDTO) throws RemoteException ;
	boolean changerEtatListePartie (Object partiesDTO) throws RemoteException ;
	JeuxDTO recupererListePartiesPourJeu () throws RemoteException ;
}