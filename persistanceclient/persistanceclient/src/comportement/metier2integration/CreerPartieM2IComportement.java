package comportement.metier2integration;

import java.lang.reflect.InvocationTargetException;

import clientRMI.ChargerService;
import comportement.Commande;
import comportement.integration2metier.ReponseCreerPartieI2MComportement;
import xml.metier2integration.CreerPartieM2I;

public class CreerPartieM2IComportement implements Commande{
	private CreerPartieM2I creerPartie;
	
	public CreerPartieM2IComportement(CreerPartieM2I creerPartie){
		this.creerPartie = creerPartie;
	}

	public void reçoiMessage() {
		int numeroPresentation = creerPartie.getNumeroPresentation();
		//Appelle de la classe PartieDTO
		Object objectPartie = ChargerService.chargerDTO("PartieDTO");
		
		String messageErreur;
		messageErreur = creerPartie.getCreationPartie().getMessageErreur();
		if(messageErreur.equals("")){			
			//Charger interface 
			Object objectServicePartie = ChargerService.chargerInterface();
	
			try {
				//Appeler les methodes partie
				objectPartie.getClass().getDeclaredMethod("setNomPartie", String.class).invoke(objectPartie, creerPartie.getCreationPartie().getNomPartie());
				objectPartie.getClass().getDeclaredMethod("setNbredejoueur", Integer.class).invoke(objectPartie, creerPartie.getCreationPartie().getNbJoueurPartie());
				
				//Appel methode creerPartie
				boolean partieCree = (boolean) objectServicePartie.getClass().getDeclaredMethod("creerPartie",Object.class).invoke(objectServicePartie, objectPartie);
				if(partieCree == false){
					messageErreur = messageErreur+"Impossible de créer la partie";						
				}
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
		}
		ReponseCreerPartieI2MComportement creerPartieI2M = new ReponseCreerPartieI2MComportement(messageErreur, objectPartie, numeroPresentation);
		creerPartieI2M.envoiMessage();
	}

	public CreerPartieM2I getCreerPartie() {
		return creerPartie;
	}

	public void setCreerPartie(CreerPartieM2I creerPartie) {
		this.creerPartie = creerPartie;
	}
}