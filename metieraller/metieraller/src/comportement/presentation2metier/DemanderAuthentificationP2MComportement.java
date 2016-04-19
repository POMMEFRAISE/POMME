package comportement.presentation2metier;

import comportement.Commande;
import comportement.metier2integration.DemanderAuthentificationM2IComportement;
import xml.presentation2metier.DemanderAuthentificationP2M;

public class DemanderAuthentificationP2MComportement implements Commande{
	private DemanderAuthentificationP2M demanderAuthentificationP2M;
	
	public DemanderAuthentificationP2MComportement(DemanderAuthentificationP2M demanderAuthentificationP2M){
		this.demanderAuthentificationP2M = demanderAuthentificationP2M;
	}
	
	public void reçoiMessage() {
		DemanderAuthentificationM2IComportement demanderAuthentificationComportement = new DemanderAuthentificationM2IComportement();
		demanderAuthentificationComportement.envoiMessage();	
	}
	
	public void envoiMessage(){

	}

	public DemanderAuthentificationP2M getDemanderAuthentification() {
		return demanderAuthentificationP2M;
	}

	public void setDemanderAuthentification(DemanderAuthentificationP2M demanderAuthentificationP2M) {
		this.demanderAuthentificationP2M = demanderAuthentificationP2M;
	}
}