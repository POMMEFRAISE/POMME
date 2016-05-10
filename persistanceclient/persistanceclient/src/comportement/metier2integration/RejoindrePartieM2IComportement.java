package comportement.metier2integration;

import java.lang.reflect.InvocationTargetException;

import clientRMI.ChargerService;
import comportement.Commande;
import comportement.integration2metier.ReponseRejoindrePartieI2MComportement;
import xml.metier2integration.RejoindrePartieM2I;

public class RejoindrePartieM2IComportement implements Commande{
	private RejoindrePartieM2I rejoindrePartie;
	
	public RejoindrePartieM2IComportement(RejoindrePartieM2I rejoindrePartie){
		this.rejoindrePartie = rejoindrePartie;
	}

	public void reçoiMessage() {
		String messageErreur = null;
		int numeroPresentation = rejoindrePartie.getNumeroPresentation();
		
		//Appelle de la classe CommandeDTO
		Object objectCommande = ChargerService.chargerDTO("CommandeDTO");
		
		try{
			Object objectServiceCommande = ChargerService.chargerInterface();

			//Appeler les methodes commande
			objectCommande.getClass().getDeclaredMethod("setMessage", String.class).invoke(objectCommande, "RejoindrePartie");
			objectCommande.getClass().getDeclaredMethod("setNumeroPresentation", Integer.class).invoke(objectCommande, numeroPresentation);
			
			//Appeller commande
			objectServiceCommande.getClass().getDeclaredMethod("enregistrerCommande",Object.class).invoke(objectServiceCommande,objectCommande);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		//Appelle de la classe JoueurDTO
		Object objectJoueur = ChargerService.chargerDTO("JoueurDTO");
		
		//Appelle de la classe PartieDTO
		Object objectPartie = ChargerService.chargerDTO("PartieDTO");
				
		//Charger interface 
		Object objectServicePartie = ChargerService.chargerInterface();
	
		try {
			//Appeler les methodes joueur
			objectJoueur.getClass().getDeclaredMethod("setLogin", String.class).invoke(objectJoueur, rejoindrePartie.getRejoindreUnePartie().getJoueur().getLoginJoueur());
			
			//Appeler les méthodes partie
			objectPartie.getClass().getDeclaredMethod("setNomPartie", String.class).invoke(objectPartie, rejoindrePartie.getRejoindreUnePartie().getPartie().getNomPartie());

			//Appeler les methodes verifierPartieRejoindre
			boolean trouvePartieRejoindre = (boolean) objectServicePartie.getClass().getDeclaredMethod("verifierPartieRejoindre",Object.class).invoke(objectServicePartie, objectPartie);
				
			//Appeler les methodes rejoindrePartie
			if(trouvePartieRejoindre == true){
				boolean rejoindrePartie = (boolean) objectServicePartie.getClass().getDeclaredMethod("rejoindrePartie",Object.class, Object.class, Integer.class).invoke(objectServicePartie, objectPartie, objectJoueur, numeroPresentation);
				
				if(rejoindrePartie == false){
					messageErreur = "Impossible de rejoindre la partie!";
				}
			}else{
				messageErreur = "La partie est fermée !";
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		ReponseRejoindrePartieI2MComportement rejoindrePartieI2M = new ReponseRejoindrePartieI2MComportement(objectPartie, messageErreur, numeroPresentation);
		rejoindrePartieI2M.envoiMessage();
	}
}