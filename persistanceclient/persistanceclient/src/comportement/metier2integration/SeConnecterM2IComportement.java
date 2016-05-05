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
		//Appelle de la classe JoueurDTO
		Object objectJoueur = ChargerService.chargerDTO("JoueurDTO");
		
		String messageErreur;
		messageErreur = seConnecter.getAuthentification().getMessageErreur();
		System.out.println("messageErreur : "+messageErreur);

		if(messageErreur == null){			
			//Charger interface 
			Object objectServiceJoueur = ChargerService.chargerInterface();
	
			try {
				//Appeler les methodes joueur
				objectJoueur.getClass().getDeclaredMethod("setLogin", String.class).invoke(objectJoueur, seConnecter.getAuthentification().getLoginAuthentification());
				objectJoueur.getClass().getDeclaredMethod("setMotDePasse", String.class).invoke(objectJoueur, seConnecter.getAuthentification().getMdpAuthentification());
				
				//Appeler les methodes verificationJoueur
				boolean trouveJoueur = (boolean) objectServiceJoueur.getClass().getDeclaredMethod("verifierJoueur",Object.class).invoke(objectServiceJoueur, objectJoueur);
				System.out.println("SeConnecter : "+trouveJoueur);
				
				//Appeler les methodes recupererJoueur
				if(trouveJoueur == true){	
					objectJoueur = objectServiceJoueur.getClass().getDeclaredMethod("recupererJoueur",Object.class).invoke(objectServiceJoueur, objectJoueur);
					System.out.println("Nom joueur : "+objectJoueur.getClass().getMethod("getNom").invoke(objectJoueur));
					System.out.println("Prenom joueur : "+objectJoueur.getClass().getMethod("getPrenom").invoke(objectJoueur));
					System.out.println("Login joueur : "+objectJoueur.getClass().getMethod("getLogin").invoke(objectJoueur));
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