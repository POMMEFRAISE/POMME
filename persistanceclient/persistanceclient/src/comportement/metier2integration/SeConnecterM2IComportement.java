package comportement.metier2integration;

import java.lang.reflect.InvocationTargetException;

import clientRMI.ChargerService;
import comportement.Commande;
import comportement.integration2metier.ReponseSeConnecterI2MComportement;
import xml.metier2integration.SeConnecterM2I;

public class SeConnecterM2IComportement implements Commande{
	private SeConnecterM2I seConnecter;
	
	public SeConnecterM2IComportement(SeConnecterM2I seConnecter){
		this.seConnecter = seConnecter;
	}

	public void reçoiMessage() {
		int numeroPresentation = seConnecter.getNumeroPresentation();
		
		//Appelle de la classe CommandeDTO
		Object objectCommande = ChargerService.chargerDTO("CommandeDTO");
		
		try{
			Object objectServiceCommande = ChargerService.chargerInterface();

			//Appeler les methodes commande
			objectCommande.getClass().getDeclaredMethod("setMessage", String.class).invoke(objectCommande, "SeConnecter");
			objectCommande.getClass().getDeclaredMethod("setNumeroPresentation", Integer.class).invoke(objectCommande, numeroPresentation);
			
			//Appeller commande
			objectServiceCommande.getClass().getDeclaredMethod("enregistrerCommande",Object.class).invoke(objectServiceCommande,objectCommande);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		//Appelle de la classe JoueurDTO
		Object objectJoueur = ChargerService.chargerDTO("JoueurDTO");
		
		String messageErreur;
		messageErreur = seConnecter.getAuthentification().getMessageErreur();

		if(messageErreur == null){			
			//Charger interface 
			Object objectServiceJoueur = ChargerService.chargerInterface();
	
			try {
				//Appeler les methodes joueur
				objectJoueur.getClass().getDeclaredMethod("setLogin", String.class).invoke(objectJoueur, seConnecter.getAuthentification().getLoginAuthentification());
				objectJoueur.getClass().getDeclaredMethod("setMotDePasse", String.class).invoke(objectJoueur, seConnecter.getAuthentification().getMdpAuthentification());
				
				//Appeler les methodes verificationJoueur
				boolean trouveJoueur = (boolean) objectServiceJoueur.getClass().getDeclaredMethod("verifierJoueur",Object.class).invoke(objectServiceJoueur, objectJoueur);
				
				//Appeler les methodes recupererJoueur
				if(trouveJoueur == true){	
					objectJoueur = objectServiceJoueur.getClass().getDeclaredMethod("recupererJoueur",Object.class).invoke(objectServiceJoueur, objectJoueur);
				}else{
					messageErreur = "Mauvais couple login / mot de passe !";
				}
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
		}
		ReponseSeConnecterI2MComportement seConnecterI2M = new ReponseSeConnecterI2MComportement(messageErreur, objectJoueur, numeroPresentation);
		seConnecterI2M.envoiMessage();
	}

	public SeConnecterM2I getSeConnecter() {
		return seConnecter;
	}

	public void setSeConnecter(SeConnecterM2I seConnecter) {
		this.seConnecter = seConnecter;
	}
}