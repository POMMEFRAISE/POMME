package serviceRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.JoueurDAO;
import dao.JoueurDAOInterface;
import dto.JoueurDTO;
import entites.JoueurEntite;

public class ServiceRMI extends UnicastRemoteObject implements ServiceRMIInterface {

	private static final long serialVersionUID = 1L;
	
	private JoueurDAOInterface joueurDAOInterface;
	//private PartieDAOInterface partieDAOInterface;
	
	public ServiceRMI() throws RemoteException {
/*		System.out.println("Service :"+service);
		if(service.equals("JoueurDAO")){
			joueurDAOInterface = new JoueurDAO();
		}else if(service.equals("PartieDAO")){
			partieDAOInterface = new PartieDAO();
		}*/
	}
	
	public JoueurDTO recupererJoueur(JoueurDTO joueurDTO) throws RemoteException {
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
	
	public boolean verificationJoueur(JoueurDTO joueurDTO) throws RemoteException {
		boolean trouve = false;
		joueurDAOInterface = new JoueurDAO();
		if (joueurDAOInterface.verificationJoueur(joueurDTO.getLogin(), joueurDTO.getMotDePasse())== true){
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
	
	public boolean rejoindrePartie(String nompartie, int nbrejoueur) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
}
	