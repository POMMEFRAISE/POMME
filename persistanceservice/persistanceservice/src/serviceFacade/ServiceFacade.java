package serviceFacade;

import java.rmi.RemoteException;

import serviceRMIImplementation.ServiceJoueurDTO;
import serviceRMIInterface.ServiceInterfaceJoueurDTO;

public class ServiceFacade {



	private ServiceInterfaceJoueurDTO serviceJoueurDTO;
	
	public ServiceInterfaceJoueurDTO getServiceJoueurDTO() {
		return serviceJoueurDTO;
	}

	public ServiceFacade() {
		try {
			serviceJoueurDTO = new ServiceJoueurDTO();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
 

	public boolean demanderAuthentification() {
		try {
			return serviceJoueurDTO.demanderAuthentification();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	

}
