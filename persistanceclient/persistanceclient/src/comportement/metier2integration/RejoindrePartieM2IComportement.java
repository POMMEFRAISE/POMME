package comportement.metier2integration;

import java.lang.reflect.InvocationTargetException;

import clientRMI.ChargerService;
import comportement.Commande;
import xml.metier2integration.RejoindrePartieM2I;

public class RejoindrePartieM2IComportement implements Commande{
	private RejoindrePartieM2I rejoindrePartie;
	
	public RejoindrePartieM2IComportement(RejoindrePartieM2I rejoindrePartie){
		this.rejoindrePartie = rejoindrePartie;
	}

	public void re�oiMessage() {
		String messageErreur;
		int numeroPresentation = rejoindrePartie.getNumeroPresentation();
		//Appelle de la classe JoueurDTO
		Object objectJoueur = ChargerService.chargerDTO("JoueurDTO");
		
		//Appelle de la classe PartieDTO
		Object objectPartie = ChargerService.chargerDTO("PartieDTO");
				
		//Charger interface 
		Object objectServicePartie = ChargerService.chargerInterface();
	
		try {
			//Appeler les methodes joueur
			objectJoueur.getClass().getDeclaredMethod("setLogin", String.class).invoke(objectJoueur, rejoindrePartie.getRejoindreUnePartie().getJoueur().getLoginJoueur());
			
			//Appeler les m�thodes partie
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
				messageErreur = "La partie est ferm�e !";
			}
			
			//Appeler les methodes fermerPartie

		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		
		Ferm� partie plein ou d�lai d�pass�
		DAns une nouvelle classe:
		R�cuperer liste joueur partie
		Avertir tout les joueurs des parties concern� par la fermeture r�c�dente : pour cela g�rer un autre statut de partie : partie en cours : mettre � en cours une foie ferm�
		
		
		
		
		ReponseSeConnecterI2MComportement seConnecterI2M = new ReponseSeConnecterI2MComportement(messageErreur, objectJoueur, numeroPresentation);
		seConnecterI2M.envoiMessage();
	}
}