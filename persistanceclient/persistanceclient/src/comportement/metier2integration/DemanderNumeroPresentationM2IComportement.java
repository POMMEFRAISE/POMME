package comportement.metier2integration;

import java.lang.reflect.InvocationTargetException;

import clientRMI.ChargerService;
import comportement.Commande;
import comportement.integration2metier.ReponseDemanderNumeroPresentationI2MComportement;
import xml.metier2integration.DemanderNumeroPresentationM2I;

public class DemanderNumeroPresentationM2IComportement implements Commande{
	private DemanderNumeroPresentationM2I demanderNumeroPresentation;
	
	public DemanderNumeroPresentationM2IComportement(DemanderNumeroPresentationM2I demanderNumeroPresentation){
		this.demanderNumeroPresentation = demanderNumeroPresentation;
	}
	
	public void reçoiMessage() {
		int numeroPresentation = 0;
		boolean enregistrerCommande = false;

		//Appelle de la classe CommandeDTO
		Object objectCommande = ChargerService.chargerDTO("CommandeDTO");
		
		try {
			Object objectServiceCommande = ChargerService.chargerInterface();
			//Appeller numeroPresentation
			numeroPresentation = (int) objectServiceCommande.getClass().getDeclaredMethod("demanderNumeroPresentation").invoke(objectServiceCommande);
			
			if(numeroPresentation != 0){
				//Appeler les methodes commande
				objectCommande.getClass().getDeclaredMethod("setMessage", String.class).invoke(objectCommande, "DemandeNumeroPresentation");
				objectCommande.getClass().getDeclaredMethod("setNumeroPresentation", Integer.class).invoke(objectCommande, numeroPresentation);
				
				//Appeller commande
				enregistrerCommande = (boolean) objectServiceCommande.getClass().getDeclaredMethod("enregistrerCommande",Object.class).invoke(objectServiceCommande,objectCommande);	
				if(enregistrerCommande == false){
					numeroPresentation = 0;
				}
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			e.printStackTrace();
		}	

		ReponseDemanderNumeroPresentationI2MComportement reponseDemanderNumeroPresentationI2MComportement = new ReponseDemanderNumeroPresentationI2MComportement(numeroPresentation);
		reponseDemanderNumeroPresentationI2MComportement.envoiMessage();
	}

	public DemanderNumeroPresentationM2I getDemanderNumeroPresentation() {
		return demanderNumeroPresentation;
	}

	public void setDemanderNumeroPresentation(DemanderNumeroPresentationM2I demanderNumeroPresentation) {
		this.demanderNumeroPresentation = demanderNumeroPresentation;
	}
}