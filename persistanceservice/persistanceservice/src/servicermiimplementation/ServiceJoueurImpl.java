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
		((JoueurDTO) joueurDTO).setEmail(joueurEntite.getEmail());
		((JoueurDTO) joueurDTO).setLogin(joueurEntite.getLogin());
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

	public JoueurDTO creerCompte(Object joueurDTO) throws RemoteException {
		JoueurEntite joueurEntite = new JoueurEntite();
		joueurEntite.setLogin(((JoueurDTO) joueurDTO).getLogin());
		joueurEntite.setNom(((JoueurDTO) joueurDTO).getNom());
		joueurEntite.setPrenom(((JoueurDTO) joueurDTO).getPrenom());
		joueurEntite.setEmail(((JoueurDTO) joueurDTO).getEmail());
		joueurEntite.setMotDePasse(((JoueurDTO) joueurDTO).getMotDePasse());
		
		boolean enregistrer = false; 
		
		if (verifierJoueur(joueurDTO)==true){
			enregistrer = daoJoueurInterface.creerCompte(joueurEntite);
			System.out.println("Connexion établie avec succès.");	
		}else{
			System.out.println("Connection impossible, les informations saisies ne sont pas correctes!\n");
		}
		if (enregistrer == true ) {
			joueurEntite = daoJoueurInterface.recupererJoueur(joueurEntite);
			System.out.println("Creation du compte");
		}
		else {
			System.out.println("Impossible de creer un joueur");
		}
		return (JoueurDTO) joueurDTO;
		
			
	}

	public JoueurDTO gererProfil(Object joueurDTO) throws RemoteException {
		JoueurEntite joueurEntite = new JoueurEntite();
		joueurEntite.setId(((JoueurDTO) joueurDTO).getId());
		joueurEntite.setLogin(((JoueurDTO) joueurDTO).getLogin());
		joueurEntite.setNom(((JoueurDTO) joueurDTO).getNom());
		joueurEntite.setPrenom(((JoueurDTO) joueurDTO).getPrenom());
		joueurEntite.setEmail(((JoueurDTO) joueurDTO).getEmail());
		joueurEntite.setMotDePasse(((JoueurDTO) joueurDTO).getMotDePasse());
	
		if (daoJoueurInterface.gererProfil(joueurEntite)== true){
			joueurEntite = daoJoueurInterface.recupererJoueur(joueurEntite);
		}else{
				System.out.println("Impossible de modifier les champs!\n");
			}
			((JoueurDTO) joueurDTO).setNom(joueurEntite.getNom());
			((JoueurDTO) joueurDTO).setPrenom(joueurEntite.getPrenom());
			((JoueurDTO) joueurDTO).setEmail(joueurEntite.getEmail());
			((JoueurDTO) joueurDTO).setLogin(joueurEntite.getLogin());
			return (JoueurDTO) joueurDTO;
	}

	
	
}
	