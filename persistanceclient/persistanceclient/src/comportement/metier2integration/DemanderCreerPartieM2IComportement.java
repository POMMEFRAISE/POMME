package comportement.metier2integration;

import java.lang.reflect.InvocationTargetException;

import clientRMI.ChargerService;
import comportement.Commande;
import comportement.integration2metier.ReponseDemanderCreerPartieI2MComportement;
import xml.metier2integration.DemanderCreerPartieM2I;

public class DemanderCreerPartieM2IComportement implements Commande{
	private DemanderCreerPartieM2I demanderCreerPartie;
	
	public DemanderCreerPartieM2IComportement(DemanderCreerPartieM2I demanderCreerPartie){
		this.demanderCreerPartie = demanderCreerPartie;
	}
	
	public void reçoiMessage() {
		boolean enregistrerCommande = false;
		int numeroPresentation = demanderCreerPartie.getNumeroPresentation();
		
		//Appelle de la classe CommandeDTO
		Object objectCommande = ChargerService.chargerDTO("CommandeDTO");
		
		try {
			Object objectServiceCommande = ChargerService.chargerInterface();

			//Appeler les methodes commande
			objectCommande.getClass().getDeclaredMethod("setMessage", String.class).invoke(objectCommande, "DemandeCreerPartie");
			objectCommande.getClass().getDeclaredMethod("setNumeroPresentation", Integer.class).invoke(objectCommande, numeroPresentation);
			
			//Appeller commande
			enregistrerCommande = (boolean) objectServiceCommande.getClass().getDeclaredMethod("enregistrerCommande",Object.class).invoke(objectServiceCommande,objectCommande);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			e.printStackTrace();
		}	

		ReponseDemanderCreerPartieI2MComportement reponseDemanderCreerPartieI2MComportement = new ReponseDemanderCreerPartieI2MComportement(enregistrerCommande, numeroPresentation);
		reponseDemanderCreerPartieI2MComportement.envoiMessage();
	}
}