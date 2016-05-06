package comportement.metier2integration;

import java.lang.reflect.InvocationTargetException;

import clientRMI.ChargerService;
import comportement.Commande;
import comportement.integration2metier.ReponseDemanderAuthentificationI2MComportement;
import xml.metier2integration.DemanderAuthentificationM2I;

public class DemanderAuthentificationM2IComportement implements Commande{
	private DemanderAuthentificationM2I demanderAuthentification;
	
	public DemanderAuthentificationM2IComportement(DemanderAuthentificationM2I demanderAuthentification){
		this.demanderAuthentification = demanderAuthentification;
	}
	
	public void reçoiMessage() {
		boolean enregistrerCommande = false;
		int numeroPresentation = demanderAuthentification.getNumeroPresentation();
		
		//Appelle de la classe CommandeDTO
		Object objectCommande = ChargerService.chargerDTO("CommandeDTO");
		
		try {
			Object objectServiceCommande = ChargerService.chargerInterface();

			//Appeler les methodes commande
			objectCommande.getClass().getDeclaredMethod("setMessage", String.class).invoke(objectCommande, "DemandeAuthentification");
			objectCommande.getClass().getDeclaredMethod("setNumeroPresentation", Integer.class).invoke(objectCommande, numeroPresentation);
			
			//Appeller commande
			enregistrerCommande = (boolean) objectServiceCommande.getClass().getDeclaredMethod("enregistrerCommande",Object.class).invoke(objectServiceCommande,objectCommande);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			e.printStackTrace();
		}	

		ReponseDemanderAuthentificationI2MComportement reponseDemanderAuthentificationI2MComportement = new ReponseDemanderAuthentificationI2MComportement(enregistrerCommande, numeroPresentation);
		reponseDemanderAuthentificationI2MComportement.envoiMessage();
	}

	public DemanderAuthentificationM2I getDemanderAuthentification() {
		return demanderAuthentification;
	}

	public void setDemanderAuthentification(DemanderAuthentificationM2I demanderAuthentification) {
		this.demanderAuthentification = demanderAuthentification;
	}
}