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
	protected ServicePartieImpl() throws RemoteException {
		daoPartieInterface = new DaoPartieImpl();
	}

	public PartieDTO recupererPartie(Object partieDTO) throws RemoteException {
		PartieEntite partieEntite = new PartieEntite();
		partieEntite.setNomPartie(((PartieDTO) partieDTO).getNomPartie());
		if (verifierPartie(partieDTO)==true){
			partieEntite = daoPartieInterface.recupererPartie(partieEntite);
			
			System.out.println("Partie recuperer .");	
		}else{
			System.out.println("les informations saisies ne sont pas correctes!\n");
		}
		((PartieDTO) partieDTO).setNomPartie(partieEntite.getNomPartie());
		((PartieDTO) partieDTO).setStatut(partieEntite.getStatut());
		((PartieDTO) partieDTO).setNbredejoueur(partieEntite.getNbredejoueur());
		((PartieDTO) partieDTO).setDatedecreation(partieEntite.getDatedecreation());
		return (PartieDTO) partieDTO;
	}

	public PartieDTO creerPartie(Object partieDTO) throws RemoteException {
		PartieEntite partieEntite = new PartieEntite();
		partieEntite.setNomPartie(((PartieDTO) partieDTO).getNomPartie());
		partieEntite.setStatut(((PartieDTO) partieDTO).getStatut());
		partieEntite.setNbredejoueur(((PartieDTO) partieDTO).getNbredejoueur());
		partieEntite.setDatedecreation(((PartieDTO) partieDTO).getDatedecreation());
		
		if (verifierPartie(partieDTO)==true){
			if (daoPartieInterface.verifierPartie(((PartieDTO) partieDTO).getNomPartie())== true){
				System.out.println("Partie créee .");	
				partieEntite = daoPartieInterface.recupererPartie(partieEntite);
			}else{
				System.out.println("Impossible de creer la partie .");	
			}
			
		}else{
			System.out.println("les informations saisies ne sont pas correctes!\n");
		}
		((PartieDTO) partieDTO).setNomPartie(partieEntite.getNomPartie());
		((PartieDTO) partieDTO).setStatut(partieEntite.getStatut());
		((PartieDTO) partieDTO).setNbredejoueur(partieEntite.getNbredejoueur());
		((PartieDTO) partieDTO).setDatedecreation(partieEntite.getDatedecreation());
		return (PartieDTO) partieDTO;
	}
	
	public boolean verifierPartie(Object partieDTO) throws RemoteException {
		boolean trouve = false;
		if (daoPartieInterface.verifierPartie(((PartieDTO) partieDTO).getNomPartie())== true){
			trouve= true;
		}else{
			trouve= false;
		}	
		return trouve;
	}


	public boolean rejoindrePartie(Object partieDTO) throws RemoteException {
		boolean rejoindre = false;
		boolean rejoindrePartie = false;
		PartieEntite partieEntite = new PartieEntite();
		partieEntite.setNomPartie(((PartieDTO) partieDTO).getNomPartie());
		partieEntite.setStatut(((PartieDTO) partieDTO).getStatut());
		partieEntite.setNbredejoueur(((PartieDTO) partieDTO).getNbredejoueur());
		partieEntite.setDatedecreation(((PartieDTO) partieDTO).getDatedecreation());
		
		if (daoPartieInterface.verifierPartie(((PartieDTO) partieDTO).getNomPartie())== true){
			if (((PartieDTO) partieDTO).getStatut() == "ouvert"){
				rejoindrePartie = daoPartieInterface.rejoindrePartie(partieEntite);
			
			}
		}else{
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

	public Object afficherEtatPartie(Object partieDTO) throws RemoteException {
		String statut = null;
		if (daoPartieInterface.verifierPartie(((PartieDTO) partieDTO).getNomPartie())== true){
			statut = daoPartieInterface.afficherEtatPartie(((PartieDTO) partieDTO).getStatut());
			System.out.println("Staut recuperer .");
		}else{
			System.out.println("Impossible de recupérer le staut");
		}
		return statut;
	}
	
	public boolean fermerPartie(Object partieDTO) throws RemoteException {
		boolean fermer = false;
		PartieEntite partieEntite = new PartieEntite();
		partieEntite.setNomPartie(((PartieDTO) partieDTO).getNomPartie());
		partieEntite.setStatut(((PartieDTO) partieDTO).getStatut());
		
		if (daoPartieInterface.verifierPartie(((PartieDTO) partieDTO).getNomPartie())== true){
			if (((PartieDTO) partieDTO).getNbredejoueur() > 4 ){
				daoPartieInterface.fermerPartie(partieEntite);
				}
				fermer= true;
			}
			else{
				fermer= false;
			}	
			
		return fermer;
	}
}
