package servicermiimplementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import daoimplementation.DaoJoueurImpl;
import daointerface.DaoJoueurInterface;
import dto.JoueurDTO;
import entites.JoueurEntite;
import servicermiinterface.ServiceJoueurInterface;

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
		
		if (verifierJoueur(joueurDTO)==true){
			joueurEntite = daoJoueurInterface.recupererJoueur(joueurEntite);
			
			System.out.println("Connexion établie avec succès.");	
		}else{
			System.out.println("Connection impossible, les informations saisies ne sont pas correctes!\n");
		}
		((JoueurDTO) joueurDTO).setNom(joueurEntite.getNom());
		((JoueurDTO) joueurDTO).setPrenom(joueurEntite.getPrenom());
		
		return (JoueurDTO) joueurDTO;
	}
	
	public boolean verifierJoueur(Object joueurDTO) throws RemoteException{
		
		boolean trouve = false;
		if (daoJoueurInterface.verifierJoueur(((JoueurDTO) joueurDTO).getLogin(), ((JoueurDTO) joueurDTO).getMotDePasse())== true){
			trouve= true;
		}else{
			trouve= false;
		}
		
		return trouve;
	}

	
	


	
	
}
	