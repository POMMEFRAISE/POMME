package comportement.metier2integration;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import clientRMI.ChargerService;
import comportement.Commande;
import comportement.integration2metier.ReponseObtenirListePartiesI2MComportement;
import xml.metier2integration.ObtenirListePartiesM2I;

public class ObtenirListePartiesM2IComportement implements Commande{
	private ObtenirListePartiesM2I obtenirListePartie;
	
	public ObtenirListePartiesM2IComportement(ObtenirListePartiesM2I obtenirListePartie){
		this.obtenirListePartie = obtenirListePartie;
	}

	public void reçoiMessage() {
		int numeroPresentation = obtenirListePartie.getNumeroPresentation();
		//Appelle de la classe PartieDTO
		Object objectParties = ChargerService.chargerDTO("PartiesDTO");
		ArrayList<Object> lesParties = new ArrayList<Object>();
	
		//Appelle de la classe CommandeDTO
		Object objectCommande = ChargerService.chargerDTO("CommandeDTO");
		
		try{
			Object objectServiceCommande = ChargerService.chargerInterface();

			//Appeler les methodes commande
			objectCommande.getClass().getDeclaredMethod("setMessage", String.class).invoke(objectCommande, "ObtenirListeParties");
			objectCommande.getClass().getDeclaredMethod("setNumeroPresentation", Integer.class).invoke(objectCommande, numeroPresentation);
			
			//Appeller commande
			objectServiceCommande.getClass().getDeclaredMethod("enregistrerCommande",Object.class).invoke(objectServiceCommande,objectCommande);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		String messageErreur = null;
		
		//Charger interface 
		Object objectServicePartie = ChargerService.chargerInterface();
	
		try {			
			objectParties = objectServicePartie.getClass().getDeclaredMethod("recupererListeParties").invoke(objectServicePartie);
			lesParties = (ArrayList<Object>) objectParties.getClass().getDeclaredMethod("getParties").invoke(objectParties);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		ReponseObtenirListePartiesI2MComportement obtenirListePartiesI2M = new ReponseObtenirListePartiesI2MComportement(lesParties, messageErreur, numeroPresentation);
		obtenirListePartiesI2M.envoiMessage();
	}

	public ObtenirListePartiesM2I getObtenirListePartie() {
		return obtenirListePartie;
	}

	public void setObtenirListePartie(ObtenirListePartiesM2I obtenirListePartie) {
		this.obtenirListePartie = obtenirListePartie;
	}
}