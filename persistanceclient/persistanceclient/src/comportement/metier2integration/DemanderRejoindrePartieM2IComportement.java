package comportement.metier2integration;

import java.lang.reflect.InvocationTargetException;

import clientRMI.ChargerService;
import comportement.Commande;
import comportement.integration2metier.ReponseDemanderRejoindrePartieI2MComportement;
import xml.metier2integration.DemanderRejoindrePartieM2I;

public class DemanderRejoindrePartieM2IComportement implements Commande{
	private DemanderRejoindrePartieM2I demanderRejoindrePartie;
	
	public DemanderRejoindrePartieM2IComportement(DemanderRejoindrePartieM2I demanderRejoindrePartie){
		this.demanderRejoindrePartie = demanderRejoindrePartie;
	}
	
	public void reçoiMessage() {
		boolean enregistrerCommande = false;
		int numeroPresentation = demanderRejoindrePartie.getNumeroPresentation();
		
		//Appelle de la classe CommandeDTO
		Object objectCommande = ChargerService.chargerDTO("CommandeDTO");
		
		try {
			Object objectServiceCommande = ChargerService.chargerInterface();

			//Appeler les methodes commande
			objectCommande.getClass().getDeclaredMethod("setMessage", String.class).invoke(objectCommande, "DemandeRejoindrePartie");
			objectCommande.getClass().getDeclaredMethod("setNumeroPresentation", Integer.class).invoke(objectCommande, numeroPresentation);
			
			//Appeller commande
			enregistrerCommande = (boolean) objectServiceCommande.getClass().getDeclaredMethod("enregistrerCommande",Object.class).invoke(objectServiceCommande,objectCommande);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			e.printStackTrace();
		}	

		ReponseDemanderRejoindrePartieI2MComportement reponseDemanderRejoindrePartieI2MComportement = new ReponseDemanderRejoindrePartieI2MComportement(enregistrerCommande, numeroPresentation);
		reponseDemanderRejoindrePartieI2MComportement.envoiMessage();
	}

	public DemanderRejoindrePartieM2I getDemanderRejoindrePartie() {
		return demanderRejoindrePartie;
	}

	public void setDemanderRejoindrePartie(DemanderRejoindrePartieM2I demanderRejoindrePartie) {
		this.demanderRejoindrePartie = demanderRejoindrePartie;
	}
}