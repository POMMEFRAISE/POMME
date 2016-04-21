package comportement.metier2integration;

import java.lang.reflect.InvocationTargetException;

import clientRMI.ChargerService;
import comportement.Commande;
import comportement.integration2metier.ReponseDemanderAuthentificationI2MComportement;
import xml.metier2integration.DemanderAuthentificationM2I;

public class DemanderAuthentificationM2IComportement implements Commande{
	private DemanderAuthentificationM2I demanderAuthentification;
	
	public DemanderAuthentificationM2IComportement(DemanderAuthentificationM2I demanderAuthentification){
		this.demanderAuthentification = demanderAuthentification;
	}
	
	public void reçoiMessage() {
		boolean enregisrerDemanderAuthentification = false;
		try {
			Object objectServiceCommande = ChargerService.chargerInterface();
			//Appeller commande
			enregisrerDemanderAuthentification = (boolean) objectServiceCommande.getClass().getDeclaredMethod("demanderAuthentification",Object.class).invoke(objectServiceCommande,"DemandeAuthentification");
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			e.printStackTrace();
		}	
		System.out.println("enregisrerDemanderAuthentification "+enregisrerDemanderAuthentification);

		ReponseDemanderAuthentificationI2MComportement reponseDemanderAuthentificationI2MComportement = new ReponseDemanderAuthentificationI2MComportement(enregisrerDemanderAuthentification);
		reponseDemanderAuthentificationI2MComportement.envoiMessage();
	}
	
	public void envoiMessage(){

	}

	public DemanderAuthentificationM2I getDemanderAuthentification() {
		return demanderAuthentification;
	}

	public void setDemanderAuthentification(DemanderAuthentificationM2I demanderAuthentification) {
		this.demanderAuthentification = demanderAuthentification;
	}
}