package servicermiimplementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import daoimplementation.DaoCommandeImpl;
import daointerface.DaoCommandeInterface;
import dto.CommandeDTO;
import entites.CommandeEntite;
import servicermiinterface.ServiceCommandeInterface;

public class ServiceCommandeImpl extends UnicastRemoteObject implements ServiceCommandeInterface{

	private static final long serialVersionUID = 1L;
	private DaoCommandeInterface daoComandeInterface;
	
	public ServiceCommandeImpl() throws RemoteException {
		daoComandeInterface = new DaoCommandeImpl();
	}
	
	@Override
	public boolean enregistrerCommande(Object commandeDTO) throws RemoteException {
		CommandeEntite commandeEntite = new CommandeEntite();
		commandeEntite.setMessage(((CommandeDTO) commandeDTO).getMessage());
		commandeEntite.setNumeroPresentation(((CommandeDTO) commandeDTO).getNumeroPresentation());
		
		boolean enregistrer = false; 
		if (daoComandeInterface.enregistrerCommande(commandeEntite) == true){
			enregistrer = true;
		}
		return enregistrer;
	}

	@Override
	public int demanderNumeroPresentation() throws RemoteException {
		int numeroPresentation = 0; 
		numeroPresentation = daoComandeInterface.demanderNumeroPresentation();
		return numeroPresentation;
	}
	
	@Override
	public Object afficherCommande() throws RemoteException {

		return null;
	}	
}