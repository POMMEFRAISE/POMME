package servicermiimplementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import daoimplementation.DaoPartieImpl;
import daointerface.DaoPartieInterface;
import dto.PartieDTO;
import entites.PartieEntite;
import servicermiinterface.ServicePartieInterface;

public class ServicePartieImpl extends UnicastRemoteObject implements ServicePartieInterface{

	private static final long serialVersionUID = 1L;
	private DaoPartieInterface daoPartieInterface;
	public ServicePartieImpl() throws RemoteException {
		daoPartieInterface = new DaoPartieImpl();
	}

	public synchronized PartieDTO recupererPartie(Object partieDTO) throws RemoteException {
		PartieEntite partieEntite = new PartieEntite();
		partieEntite.setNomPartie(((PartieDTO) partieDTO).getNomPartie());
		if (verifierPartie(partieDTO)==true){
			partieEntite = daoPartieInterface.recupererPartie(partieEntite);
			System.out.println("Partie recuperer .");	
		}
		((PartieDTO) partieDTO).setNomPartie(partieEntite.getNomPartie());
		((PartieDTO) partieDTO).setStatut(partieEntite.getStatut());
		((PartieDTO) partieDTO).setNbredejoueur(partieEntite.getNbredejoueur());
		((PartieDTO) partieDTO).setDatedecreation(partieEntite.getDatedecreation());
		return (PartieDTO) partieDTO;
	}

	public synchronized boolean creerPartie(Object partieDTO) throws RemoteException {
		PartieEntite partieEntite = new PartieEntite();
		partieEntite.setNomPartie(((PartieDTO) partieDTO).getNomPartie());
		partieEntite.setNbredejoueur(((PartieDTO) partieDTO).getNbredejoueur());
		boolean creer = false;
		boolean enregistrer = false; 
		enregistrer = daoPartieInterface.creerPartie(partieEntite);
		if (enregistrer == true){
			System.out.println("Partie créee .");	
			creer= true;
			}else{
				System.out.println("Impossible de creer la partie .");	
				creer= false;
			}
			
		return creer;
	}
	
	public synchronized boolean verifierPartie(Object partieDTO) throws RemoteException {
		boolean trouve = false;
		if (daoPartieInterface.verifierPartie(((PartieDTO) partieDTO).getNomPartie())== true){
			trouve= true;
		}else{
			trouve= false;
		}	
		return trouve;
	}


	public synchronized boolean rejoindrePartie(Object partieDTO) throws RemoteException {
		boolean rejoindre = false;
		boolean rejoindrePartie = false;
		
		PartieEntite partieEntite = new PartieEntite();
		partieEntite.setNomPartie(((PartieDTO) partieDTO).getNomPartie());
		partieEntite.setStatut(((PartieDTO) partieDTO).getStatut());
		partieEntite.setNbredejoueur(((PartieDTO) partieDTO).getNbredejoueur());
		partieEntite.setDatedecreation(((PartieDTO) partieDTO).getDatedecreation());
	
		if (daoPartieInterface.verifierPartie(((PartieDTO) partieDTO).getNomPartie())== true){
			if (((PartieDTO) partieDTO).getStatut() != "fermer"){
				rejoindrePartie = daoPartieInterface.rejoindrePartie(partieEntite);
				
			}else{
			
			}
		
		}
		else{
			rejoindrePartie = false;	
		}
		
		if (rejoindrePartie == true ){
			System.out.println("Joueur rejoint la partie");
			rejoindre= true;
		}else{
			System.out.println("imposible de rejoindre la partie");
			rejoindre= false;
			}
		
		return rejoindre;
	}

	public synchronized Object afficherEtatPartie(Object partieDTO) throws RemoteException {
		String statut = null;
		if(daoPartieInterface.verifierPartie(((PartieDTO) partieDTO).getNomPartie())== true){
			statut = daoPartieInterface.afficherEtatPartie(((PartieDTO) partieDTO).getNomPartie());
			System.out.println("Staut recuperer .");
		}else{
			System.out.println("Impossible de recupérer le staut");
		}
		return statut;
	}
	
	public synchronized boolean fermerPartie(Object partieDTO) throws RemoteException {
		boolean fermer = false;
		PartieEntite partieEntite = new PartieEntite();
		partieEntite.setNomPartie(((PartieDTO) partieDTO).getNomPartie());
		partieEntite.setStatut(((PartieDTO) partieDTO).getStatut());
		System.out.println(partieDTO);
		System.out.println(partieEntite);
		if (daoPartieInterface.verifierPartie(((PartieDTO) partieDTO).getNomPartie())== true){
			System.out.println("Impossible de recupérer le staut");

			if (((PartieDTO) partieDTO).getNbredejoueur() >= 3 ){
				System.out.println("Impossible de recupérer le staut");

				daoPartieInterface.fermerPartie(partieEntite);
				fermer= true;
				}
				
				System.out.println("Impossible de recupérer le staut");

			}
			else{
				fermer= false;
				System.out.println("Impossible de recupérer le staut");

			}	
			
		return fermer;
	}
}
