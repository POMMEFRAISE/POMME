package servicermiimplementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import daoimplementation.DaoPartieImpl;
import daointerface.DaoPartieInterface;
import dto.JeuDTO;
import dto.JeuxDTO;
import dto.JoueurDTO;
import dto.JoueursDTO;
import dto.PartieDTO;
import dto.PartiesDTO;
import entites.JeuEntite;
import entites.JeuxEntite;
import entites.JoueurEntite;
import entites.PartieEntite;
import entites.PartiesEntite;
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
		}
		((PartieDTO) partieDTO).setNomPartie(partieEntite.getNomPartie());
		((PartieDTO) partieDTO).setStatut(partieEntite.getStatut());
		((PartieDTO) partieDTO).setNbredejoueur(partieEntite.getNbredejoueur());
		((PartieDTO) partieDTO).setDatedecreation(partieEntite.getDatedecreation());
		return (PartieDTO) partieDTO;
	}

	public synchronized PartiesDTO recupererListeParties() throws RemoteException {
		PartiesEntite partiesEntite = new PartiesEntite();
		partiesEntite = daoPartieInterface.recupererListeParties();
		
		PartiesDTO partiesDTO = new PartiesDTO();
		for(PartieEntite partieEntite : partiesEntite.getParties()){
			PartieDTO partieDTO = new PartieDTO();
			((PartieDTO) partieDTO).setNomPartie(partieEntite.getNomPartie());
			((PartieDTO) partieDTO).setNbredejoueur(partieEntite.getNbredejoueur());			
			partiesDTO.add(partieDTO);
		}

		return partiesDTO;
	}
	
	public synchronized JeuxDTO recupererListePartiesPourJeu() throws RemoteException {
		JeuxEntite jeuxEntite = new JeuxEntite();
		jeuxEntite = daoPartieInterface.recupererListePartiesPourJeu();
		
		JeuxDTO jeuxDTO = new JeuxDTO();
		for(JeuEntite jeuEntite : jeuxEntite.getJeux()){
			JeuDTO jeuDTO = new JeuDTO();
			JoueursDTO joueursDTO = new JoueursDTO();
			for(JoueurEntite joueurEntite : jeuEntite.getJoueurs().getJoueurs()){
				JoueurDTO joueurDTO = new JoueurDTO();
				((JoueurDTO) joueurDTO).setLogin(joueurEntite.getLogin());
				((JoueurDTO) joueurDTO).setNumeroPresentation(joueurEntite.getNumeroPresentation());
				((JoueurDTO) joueurDTO).setPositionJeu(joueurEntite.getPositionJeu());
				joueursDTO.add(joueurDTO);
			}
			
			PartieDTO partieDTO = new PartieDTO();
			((PartieDTO) partieDTO).setNomPartie(jeuEntite.getPartie().getNomPartie());
			((PartieDTO) partieDTO).setNbredejoueur(jeuEntite.getPartie().getNbredejoueur());
			jeuDTO.setPartie(partieDTO);
			jeuDTO.setJoueurs(joueursDTO);

			jeuxDTO.add(jeuDTO);
		}
		return jeuxDTO;
	}
	public synchronized PartiesDTO recupererListePartiesPourChangerEtat() throws RemoteException {
		PartiesEntite partiesEntite = new PartiesEntite();
		partiesEntite = daoPartieInterface.recupererListePartiesPourChangerEtat();
		
		PartiesDTO partiesDTO = new PartiesDTO();
		for(PartieEntite partieEntite : partiesEntite.getParties()){
			PartieDTO partieDTO = new PartieDTO();
			((PartieDTO) partieDTO).setNomPartie(partieEntite.getNomPartie());
			partiesDTO.add(partieDTO);
		}

		return partiesDTO;
	}
	
	public synchronized boolean creerPartie(Object partieDTO) throws RemoteException {
		PartieEntite partieEntite = new PartieEntite();
		partieEntite.setNomPartie(((PartieDTO) partieDTO).getNomPartie());
		partieEntite.setNbredejoueur(((PartieDTO) partieDTO).getNbredejoueur());
		boolean creer = false;
		boolean enregistrer = false; 
		enregistrer = daoPartieInterface.creerPartie(partieEntite);
		if (enregistrer == true){
			creer= true;
			}else{
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

	public synchronized boolean verifierPartieRejoindre(Object partieDTO) throws RemoteException {
		boolean trouve = false;
		if (daoPartieInterface.verifierPartieRejoindre(((PartieDTO) partieDTO).getNomPartie())== true){
			trouve= true;
		}else{
			trouve= false;
		}	
		return trouve;
	}

	public synchronized boolean rejoindrePartie(Object partieDTO, Object joueurDTO, Integer numeroPresentation) throws RemoteException {
		boolean rejoindrePartie = false;
		boolean rejoindre = false;
		
		PartieEntite partieEntite = new PartieEntite();
		partieEntite.setNomPartie(((PartieDTO) partieDTO).getNomPartie());

		JoueurEntite joueurEntite = new JoueurEntite();
		joueurEntite.setLogin(((JoueurDTO) joueurDTO).getLogin());
		
		rejoindrePartie = daoPartieInterface.rejoindrePartie(partieEntite, joueurEntite, numeroPresentation);
				
		if (rejoindrePartie == true ){
			rejoindre= true;
		}else{
			rejoindre= false;
		}		
		return rejoindre;
	}

	public synchronized Object afficherEtatPartie(Object partieDTO) throws RemoteException {
		String statut = null;
		if(daoPartieInterface.verifierPartie(((PartieDTO) partieDTO).getNomPartie())== true){
			statut = daoPartieInterface.afficherEtatPartie(((PartieDTO) partieDTO).getNomPartie());
		}
		return statut;
	}
	
	public synchronized boolean fermerPartie() throws RemoteException {
		boolean fermer = false;
		PartiesEntite listeParties= daoPartieInterface.recupererListePartiesAFermer();
		for(PartieEntite partie : listeParties.getParties()){
			fermer = daoPartieInterface.fermerPartie(partie);
		}
		
		return fermer;
	}
	
	public synchronized boolean changerEtatListePartie(Object partiesDTO) throws RemoteException {
		boolean etatChanger = false;
		PartiesEntite partiesEntite = new PartiesEntite();

		for(PartieDTO partie : ((PartiesDTO) partiesDTO).getParties()){
			PartieEntite partieEntite = new PartieEntite();
			partieEntite.setNomPartie(partie.getNomPartie());
			partiesEntite.add(partieEntite);
		}
		
		etatChanger = daoPartieInterface.changerEtatListePartie(partiesEntite);
		
		return etatChanger;
	}
}
