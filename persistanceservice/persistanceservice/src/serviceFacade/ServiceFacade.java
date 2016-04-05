package serviceFacade;

import java.rmi.RemoteException;

import serviceRMIImplementation.ServiceJoueurImpl;
import serviceRMIInterface.ServiceJoueurInterface;

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
	
	public boolean verificationJoueur (Object joueurDTO) {
		try {
			return serviceJoueurDTO.verificationJoueur(joueurDTO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
 

	

}
