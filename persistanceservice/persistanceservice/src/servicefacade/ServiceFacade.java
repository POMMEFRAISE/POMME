package servicefacade;

import java.rmi.RemoteException;

import servicermiimplementation.ServiceJoueurImpl;
import servicermiinterface.ServiceJoueurInterface;

public class ServiceFacade {
	private ServiceJoueurInterface serviceJoueurDTO;
	
	public ServiceJoueurInterface getServiceJoueur() {
		return serviceJoueurDTO;
	}

	public ServiceFacade() throws RemoteException {
			serviceJoueurDTO = new ServiceJoueurImpl();

	}
	
	public Object recupererJoueur (Object joueurDTO)  {
		try {
			return serviceJoueurDTO.recupererJoueur(joueurDTO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return joueurDTO;
	}
	
	public boolean verifierJoueur (Object joueurDTO) {
		try {
			return serviceJoueurDTO.verifierJoueur(joueurDTO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
 

	

}
