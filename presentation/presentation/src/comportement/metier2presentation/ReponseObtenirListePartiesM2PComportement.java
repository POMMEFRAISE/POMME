package comportement.metier2presentation;

import comportement.Commande;
import model.Partie;
import model.Parties;
import xml.metier2presentation.PartieM2P;
import xml.metier2presentation.ReponseObtenirListePartiesM2P;

public class ReponseObtenirListePartiesM2PComportement implements Commande{
	private ReponseObtenirListePartiesM2P reponseObtenirListePartiesM2P;
	private String messageErreur;
	private Parties listeParties = new Parties();
	
	public ReponseObtenirListePartiesM2PComportement(ReponseObtenirListePartiesM2P reponseObtenirListePartiesM2P){
		this.reponseObtenirListePartiesM2P = reponseObtenirListePartiesM2P;
	}

	public Parties reçoiMessage() {
		for(PartieM2P unePartie : reponseObtenirListePartiesM2P.getListeParties().getListeParties()){
			Partie partie = new Partie();
			partie.setNom(unePartie.getNomPartie());
			partie.setNbJoueurs(unePartie.getNbJoueurPartie());
			listeParties.add(partie);
		}
		
		messageErreur = reponseObtenirListePartiesM2P.getListeParties().getMessageErreur();
		listeParties.setMessage(messageErreur);
		
		return listeParties;
	}
}