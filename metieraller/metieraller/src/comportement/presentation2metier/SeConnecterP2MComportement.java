package comportement.presentation2metier;

import comportement.Commande;
import comportement.metier2integration.SeConnecterM2IComportement;
import xml.presentation2metier.SeConnecterP2M;

public class SeConnecterP2MComportement implements Commande{
	private SeConnecterP2M seConnecterP2M;
	
	public SeConnecterP2MComportement(SeConnecterP2M seConnecterP2M){
		this.seConnecterP2M = seConnecterP2M;
	}
	
	
	public void reçoiMessage() {
		SeConnecterM2IComportement seConnecterM2I = new SeConnecterM2IComportement(
				seConnecterP2M.getAuthentification().getLoginAuthentification(),
				seConnecterP2M.getAuthentification().getMdpAuthentification()
		);
		seConnecterM2I.envoiMessage();
	}
	
	public void envoiMessage(){
		
	}

	public SeConnecterP2M getSeConnecterP2M() {
		return seConnecterP2M;
	}

	public void setSeConnecterP2M(SeConnecterP2M seConnecterP2M) {
		this.seConnecterP2M = seConnecterP2M;
	}
}