package comportement.metier2presentation;

import activeMQ.Producteur;
import model.PartieMetierRetour;
import xml.metier2presentation.JeuM2P;
import xml.metier2presentation.ObjectFactory;
import xml.metier2presentation.PartieM2P;
import xml.metier2presentation.ReponseRejoindrePartieM2P;


public class ReponseRejoindrePartieM2PComportement{
	private PartieMetierRetour partieMetierRetour;
	private String messageErreur;
	private int numeroPresentation;

	public ReponseRejoindrePartieM2PComportement(PartieMetierRetour partieMetierRetour,
			String messageErreur, int numeroPresentation){
		this.partieMetierRetour = partieMetierRetour;
		this.messageErreur = messageErreur;
		this.numeroPresentation = numeroPresentation;
	}

	public void envoiMessage() {
		ObjectFactory objFactory = new ObjectFactory();
		JeuM2P jeu = objFactory.createJeuM2P();
		PartieM2P partie = objFactory.createPartieM2P();
		partie.setNomPartie(partieMetierRetour.getNomPartie());
		jeu.setMessageErreur(messageErreur);
		jeu.setPartie(partie);
		ReponseRejoindrePartieM2P reponseRejoindrePartie = objFactory.createReponseRejoindrePartieM2P();
		reponseRejoindrePartie.setJeu(jeu);
		
		new Producteur(reponseRejoindrePartie, numeroPresentation);

	}
}