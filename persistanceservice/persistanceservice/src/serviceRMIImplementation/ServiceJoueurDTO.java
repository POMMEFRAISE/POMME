package serviceRMIImplementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import dao.JoueurDAOImpl;
import dao.JoueurDAOInterface;
import dto.JoueurDTO;
import entites.JoueurEntite;
import serviceRMIInterface.ServiceRMIInterface;

public class ServiceJoueurDTO extends UnicastRemoteObject implements ServiceRMIInterface {

	private static final long serialVersionUID = 1L;
	
	private JoueurDAOInterface joueurDAOInterface;
	
	public ServiceJoueurDTO() throws RemoteException {
		joueurDAOInterface = new JoueurDAOImpl();
	}
	
	public JoueurDTO recupererJoueur(JoueurDTO joueurDTO) throws RemoteException{
		System.out.println("# Connexion utilisateur:");
		JoueurEntite joueurEntite = new JoueurEntite();
		joueurEntite.setLogin(joueurDTO.getLogin());
		joueurEntite.setMotDePasse(joueurDTO.getMotDePasse());
		
		if (verificationJoueur(joueurDTO)==true){
			joueurEntite = joueurDAOInterface.recupererJoueur(joueurEntite);
			
			System.out.println("Connexion établie avec succès.");	
		}else{
			System.out.println("Connection impossible, les informations saisies ne sont pas correctes!\n");
		}
		joueurDTO.setNom(joueurEntite.getNom());
		joueurDTO.setPrenom(joueurEntite.getPrenom());
		
		return joueurDTO;
	}
	
	public boolean verificationJoueur(Object joueurDTO) throws RemoteException{
		
		boolean trouve = false;
		if (joueurDAOInterface.verificationJoueur(((JoueurDTO) joueurDTO).getLogin(), ((JoueurDTO) joueurDTO).getMotDePasse())== true){
			trouve= true;
		}else{
			trouve= false;
		}
		
		return trouve;
	}
	
	//Enregistrement de la commande dans la bd
	public boolean demanderAuthentification() throws RemoteException{
		System.out.println("Demander Authentification");
		return true;
	}

	


	
}
	