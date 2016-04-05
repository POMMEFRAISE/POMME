package serviceRMIImplementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import daoImplementation.DaoJoueurImpl;
import daoInterface.DaoJoueurInterface;
import dto.JoueurDTO;
import entites.JoueurEntite;
import serviceRMIInterface.ServiceJoueurInterface;

public class ServiceJoueurImpl extends UnicastRemoteObject implements ServiceJoueurInterface {

	private static final long serialVersionUID = 1L;
	private DaoJoueurInterface daoJoueurInterface;
	public ServiceJoueurImpl() throws RemoteException {
		daoJoueurInterface = new DaoJoueurImpl();
	}
	
	public JoueurDTO recupererJoueur(Object joueurDTO) throws RemoteException{
		System.out.println("# Connexion utilisateur:");
		JoueurEntite joueurEntite = new JoueurEntite();
		joueurEntite.setLogin(((JoueurDTO) joueurDTO).getLogin());
		joueurEntite.setMotDePasse(((JoueurDTO) joueurDTO).getMotDePasse());
		
		if (verificationJoueur(joueurDTO)==true){
			joueurEntite = daoJoueurInterface.recupererJoueur(joueurEntite);
			
			System.out.println("Connexion établie avec succès.");	
		}else{
			System.out.println("Connection impossible, les informations saisies ne sont pas correctes!\n");
		}
		((JoueurDTO) joueurDTO).setNom(joueurEntite.getNom());
		((JoueurDTO) joueurDTO).setPrenom(joueurEntite.getPrenom());
		
		return (JoueurDTO) joueurDTO;
	}
	
	public boolean verificationJoueur(Object joueurDTO) throws RemoteException{
		
		boolean trouve = false;
		if (daoJoueurInterface.verificationJoueur(((JoueurDTO) joueurDTO).getLogin(), ((JoueurDTO) joueurDTO).getMotDePasse())== true){
			trouve= true;
		}else{
			trouve= false;
		}
		
		return trouve;
	}
	


	
	
}
	