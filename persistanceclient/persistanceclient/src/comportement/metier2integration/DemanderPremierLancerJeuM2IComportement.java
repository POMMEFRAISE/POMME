package comportement.metier2integration;

import java.lang.reflect.InvocationTargetException;

import clientRMI.ChargerService;
import comportement.Commande;
import comportement.integration2metier.ReponseDemanderPremierLancerJeuI2MComportement;
import xml.metier2integration.DemanderPremierLancerJeuM2I;
import xml.metier2integration.JoueurM2I;

public class DemanderPremierLancerJeuM2IComportement implements Commande{
	private DemanderPremierLancerJeuM2I demanderPremierLancerJeuM2I;
	
	public DemanderPremierLancerJeuM2IComportement(DemanderPremierLancerJeuM2I demanderPremierLancerJeuM2I){
		this.demanderPremierLancerJeuM2I = demanderPremierLancerJeuM2I;
	}
	
	public void reçoiMessage() {
		boolean enregistrerCommande = false;
		String messageErreur = "";
		int numeroPresentation = demanderPremierLancerJeuM2I.getNumeroPresentation();
		
		//Appelle de la classe CommandeDTO
		Object objectCommande = ChargerService.chargerDTO("CommandeDTO");
		
		try {
			Object objectServiceCommande = ChargerService.chargerInterface();

			//Appeler les methodes commande
			objectCommande.getClass().getDeclaredMethod("setMessage", String.class).invoke(objectCommande, "DemanderPremierLancerJeu");
			objectCommande.getClass().getDeclaredMethod("setNumeroPresentation", Integer.class).invoke(objectCommande, numeroPresentation);
			
			//Appeller commande
			enregistrerCommande = (boolean) objectServiceCommande.getClass().getDeclaredMethod("enregistrerCommande",Object.class).invoke(objectServiceCommande,objectCommande);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			e.printStackTrace();
		}
		
		//Appelle de la classe JoueursDTO
		Object objectJoueurs = ChargerService.chargerDTO("JoueursDTO");
		
		//Appelle de la classe PartieDTO
		Object objectPartie = ChargerService.chargerDTO("PartieDTO");
		
		//Appelle de la classe JeuDTO
		Object objectJeu = ChargerService.chargerDTO("JeuDTO");
		
		try{
			//Appeler les méthodes partie
			objectPartie.getClass().getDeclaredMethod("setNomPartie", String.class).invoke(objectPartie, demanderPremierLancerJeuM2I.getJeu().getPartie().getNomPartie());
			
			for(JoueurM2I unJoueur : demanderPremierLancerJeuM2I.getJeu().getListeJoueurs().getListeJoueurs()){
				//Appelle de la classe JoueurDTO
				Object objectJoueur = ChargerService.chargerDTO("JoueurDTO");
				
				//Appeler les methodes joueur
				objectJoueur.getClass().getDeclaredMethod("setLogin", String.class).invoke(objectJoueur, unJoueur.getLoginJoueur());
				objectJoueur.getClass().getDeclaredMethod("setNumeroPresentation", Integer.class).invoke(objectJoueur, unJoueur.getNumeroPresentation());
				objectJoueur.getClass().getDeclaredMethod("setPositionJeu", Integer.class).invoke(objectJoueur, unJoueur.getPositionJeu());
				objectJoueur.getClass().getDeclaredMethod("setResultatPremierLancer", Integer.class).invoke(objectJoueur, unJoueur.getResultatPremierLancer());
				objectJoueur.getClass().getDeclaredMethod("setDoitJouer", Boolean.class).invoke(objectJoueur, unJoueur.isDoitJoueur());

				Object objectJoueurGauche = ChargerService.chargerDTO("JoueurDTO");
				objectJoueurGauche.getClass().getDeclaredMethod("setLogin", String.class).invoke(objectJoueurGauche, unJoueur.getJoueurGauche().getLoginJoueur());

				Object objectJoueurDroite = ChargerService.chargerDTO("JoueurDTO");
				objectJoueurDroite.getClass().getDeclaredMethod("setLogin", String.class).invoke(objectJoueurDroite, unJoueur.getJoueurDroite().getLoginJoueur());

				objectJoueur.getClass().getDeclaredMethod("setJoueurGauche", Object.class).invoke(objectJoueur, objectJoueurGauche);
				objectJoueur.getClass().getDeclaredMethod("setJoueurDroite", Object.class).invoke(objectJoueur, objectJoueurDroite);
				
				objectJoueurs.getClass().getDeclaredMethod("add", Object.class).invoke(objectJoueurs, objectJoueur);
			}
			
			//Appeler les méthodes jeu
			objectJeu.getClass().getDeclaredMethod("setPartie", Object.class).invoke(objectJeu, objectPartie);
			objectJeu.getClass().getDeclaredMethod("setJoueurs", Object.class).invoke(objectJeu, objectJoueurs);

			
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		ReponseDemanderPremierLancerJeuI2MComportement reponseDemanderPremierLancerJeuI2MComportement = new ReponseDemanderPremierLancerJeuI2MComportement(enregistrerCommande, numeroPresentation, objectJeu);
		reponseDemanderPremierLancerJeuI2MComportement.envoiMessage();
	}

	public DemanderPremierLancerJeuM2I getDemanderPremierLancerJeuM2I() {
		return demanderPremierLancerJeuM2I;
	}

	public void setDemanderPremierLancerJeuM2I(DemanderPremierLancerJeuM2I demanderPremierLancerJeuM2I) {
		this.demanderPremierLancerJeuM2I = demanderPremierLancerJeuM2I;
	}
}