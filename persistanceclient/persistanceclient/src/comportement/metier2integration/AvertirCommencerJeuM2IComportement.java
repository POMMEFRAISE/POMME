package comportement.metier2integration;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import clientRMI.ChargerService;
import comportement.integration2metier.ReponseAvertirCommencerJeuI2MComportement;

public class AvertirCommencerJeuM2IComportement implements Runnable{
	boolean running = true;
	public AvertirCommencerJeuM2IComportement(){
		
	}
	
	public synchronized void recupererPartieACommencer(){
		Object objectParties = ChargerService.chargerDTO("PartiesDTO");
		ArrayList<Object> lesParties = new ArrayList<Object>();
		
		Object objectJeux = ChargerService.chargerDTO("JeuxDTO");
		ArrayList<Object> lesJeux = new ArrayList<Object>();

		//Charger interface 
		Object objectServicePartie = ChargerService.chargerInterface();
	
		try{
			//Appeler les methodes fermerPartie
			objectServicePartie.getClass().getDeclaredMethod("fermerPartie").invoke(objectServicePartie);

			objectParties = objectServicePartie.getClass().getDeclaredMethod("recupererListePartiesPourChangerEtat").invoke(objectServicePartie);
			lesParties = (ArrayList<Object>) objectParties.getClass().getDeclaredMethod("getParties").invoke(objectParties);
			
			if(lesParties.size() > 0){
				boolean mettreStatut = (boolean) objectServicePartie.getClass().getDeclaredMethod("changerEtatListePartie", Object.class).invoke(objectServicePartie, objectParties);
				
				if(mettreStatut == true){
					objectJeux = objectServicePartie.getClass().getDeclaredMethod("recupererListePartiesPourJeu").invoke(objectServicePartie);
					lesJeux = (ArrayList<Object>) objectJeux.getClass().getDeclaredMethod("getJeux").invoke(objectJeux);
			
					ReponseAvertirCommencerJeuI2MComportement avertirCommencerJeuI2MComportement = new ReponseAvertirCommencerJeuI2MComportement(lesJeux);
					avertirCommencerJeuI2MComportement.envoiMessage();
				}
				

			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		while(running){
	        try
	        {
	    		recupererPartieACommencer();
	    		Thread.sleep (20000);
	        } catch (InterruptedException exception){
	        	
	        }
		}
	}
}