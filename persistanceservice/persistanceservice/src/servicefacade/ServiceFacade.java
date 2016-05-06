package servicefacade;

import java.rmi.RemoteException;

import servicermiimplementation.ServiceCommandeImpl;
import servicermiimplementation.ServiceJoueurImpl;
import servicermiimplementation.ServicePartieImpl;
import servicermiinterface.ServiceCommandeInterface;
import servicermiinterface.ServiceJoueurInterface;
import servicermiinterface.ServicePartieInterface;

public class ServiceFacade {
	private ServiceJoueurInterface serviceJoueur;
	private ServicePartieInterface servicePartie;
    private ServiceCommandeInterface serviceCommande;
	
	
	public ServiceCommandeInterface getserviceCommande() {
		return serviceCommande;
	}
	public ServiceJoueurInterface getServiceJoueur() {
		return serviceJoueur;
	}
	public ServicePartieInterface getServicePartie() {
		return servicePartie;
	}

	public ServiceFacade() throws RemoteException {
		serviceJoueur = new ServiceJoueurImpl();
		servicePartie = new ServicePartieImpl();
		serviceCommande = new ServiceCommandeImpl();


	}
	
	// Service Joueur
	
	public synchronized Object recupererJoueur (Object joueurDTO)  {
		try {
			return serviceJoueur.recupererJoueur(joueurDTO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return joueurDTO;
	}
	
	public synchronized Object verifierJoueur (Object joueurDTO) {
		try {
			return serviceJoueur.verifierJoueur(joueurDTO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	public synchronized Object creerCompte(Object joueurDTO){
		try {
			return serviceJoueur.creerCompte(joueurDTO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return joueurDTO;
	}
	
	
	///A REFAIRE ////
	//////////////
	public synchronized Object gererProfil(Object joueurDTO) {
		try {
			return serviceJoueur.gererProfil(joueurDTO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return joueurDTO;
	}

	
	// Service Partie
	
	public synchronized Object recupererPartie(Object partieDTO){
		try {
			return servicePartie.recupererPartie(partieDTO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return partieDTO;
	}

	public synchronized Object recupererListeParties(){
		try {
			return servicePartie.recupererListeParties();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public synchronized Object creerPartie(Object partieDTO){
		try {
			return servicePartie.creerPartie(partieDTO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return partieDTO;
		
	}
	public synchronized Object verifierPartie(Object partieDTO){
		try {
			return servicePartie.verifierPartie(partieDTO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	public synchronized Object rejoindrePartie(Object partieDTO){
		try {
			return servicePartie.rejoindrePartie(partieDTO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	public synchronized Object afficherEtatPartie(Object partieDTO){
		try {
			
			return servicePartie.afficherEtatPartie(partieDTO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return String.class;
	}
	
	
	public synchronized Object fermerPartie(Object partieDTO){
		try {
			return servicePartie.fermerPartie(partieDTO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	//Commande
	

	public synchronized boolean enregistrerCommande (Object commandeDTO)  {
		try {
			return serviceCommande.enregistrerCommande(commandeDTO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public synchronized int demanderNumeroPresentation ()  {
		try {
			return serviceCommande.demanderNumeroPresentation();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public synchronized Object afficherCommande(){
		try {
			return serviceCommande.afficherCommande();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return Object.class;	
	}
}