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
	
	public synchronized JoueurDTO recupererJoueur(Object joueurDTO) throws RemoteException{
		JoueurEntite joueurEntite = new JoueurEntite();
		joueurEntite.setLogin(((JoueurDTO) joueurDTO).getLogin());
		joueurEntite.setMotDePasse(((JoueurDTO) joueurDTO).getMotDePasse());
		
		if (verifierJoueur(joueurDTO)==true){
			joueurEntite = daoJoueurInterface.recupererJoueur(joueurEntite);
		}
		((JoueurDTO) joueurDTO).setNom(joueurEntite.getNom());
		((JoueurDTO) joueurDTO).setPrenom(joueurEntite.getPrenom());
		((JoueurDTO) joueurDTO).setEmail(joueurEntite.getEmail());
		((JoueurDTO) joueurDTO).setLogin(joueurEntite.getLogin());
		((JoueurDTO) joueurDTO).setId(joueurEntite.getId());

		return (JoueurDTO) joueurDTO;
	}
	
	public synchronized boolean verifierJoueur(Object joueurDTO) throws RemoteException{
		
		boolean trouve = false;
		if (daoJoueurInterface.verifierJoueur(((JoueurDTO) joueurDTO).getLogin(), ((JoueurDTO) joueurDTO).getMotDePasse())== true){
			trouve= true;
		}
		return trouve;
	}

	public synchronized boolean creerCompte(Object joueurDTO) throws RemoteException {
		JoueurEntite joueurEntite = new JoueurEntite();
		joueurEntite.setNom(((JoueurDTO) joueurDTO).getNom());
		joueurEntite.setPrenom(((JoueurDTO) joueurDTO).getPrenom());
		joueurEntite.setEmail(((JoueurDTO) joueurDTO).getEmail());
		joueurEntite.setLogin(((JoueurDTO) joueurDTO).getLogin());
		joueurEntite.setMotDePasse(((JoueurDTO) joueurDTO).getMotDePasse());
		boolean trouve = false;
		boolean enregistrer = false; 
		enregistrer = daoJoueurInterface.creerCompte(joueurEntite);
		if (enregistrer == true ) {
			System.out.print("Joueur Créee");

			joueurEntite = daoJoueurInterface.recupererJoueur(joueurEntite);
			trouve= true;
		}
		return trouve;
		
			
	}

	public synchronized boolean gererProfil(Object joueurDTO) throws RemoteException {
		JoueurEntite joueurEntite = new JoueurEntite();
		joueurEntite.setId(((JoueurDTO) joueurDTO).getId());
		joueurEntite.setLogin(((JoueurDTO) joueurDTO).getLogin());
		joueurEntite.setNom(((JoueurDTO) joueurDTO).getNom());
		joueurEntite.setPrenom(((JoueurDTO) joueurDTO).getPrenom());
		joueurEntite.setEmail(((JoueurDTO) joueurDTO).getEmail());
		joueurEntite.setMotDePasse(((JoueurDTO) joueurDTO).getMotDePasse());
		boolean trouve = false;

		if (daoJoueurInterface.gererProfil(joueurEntite)== true){
			joueurEntite = daoJoueurInterface.recupererJoueur(joueurEntite);
			trouve= true;

		}
			((JoueurDTO) joueurDTO).setNom(joueurEntite.getNom());
			((JoueurDTO) joueurDTO).setPrenom(joueurEntite.getPrenom());
			((JoueurDTO) joueurDTO).setEmail(joueurEntite.getEmail());
			((JoueurDTO) joueurDTO).setLogin(joueurEntite.getLogin());
			return trouve;
	}

	
	
}
	