package comportement.metier2integration;

import comportement.Commande;
import xml.metier2integration.DemanderAuthentificationM2I;

public class DemanderAuthentificationM2IComportement implements Commande{
	private DemanderAuthentificationM2I demanderAuthentification;
	
	public DemanderAuthentificationM2IComportement(DemanderAuthentificationM2I demanderAuthentification){
		this.demanderAuthentification = demanderAuthentification;
	}
	
	public void reçoiMessage() {
	
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