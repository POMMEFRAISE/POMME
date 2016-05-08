package comportement.metier2presentation;

import activeMQ.Producteur;
import model.JeuMetierRetour;
import model.JeuxMetierRetour;
import model.JoueurMetierRetour;
import xml.metier2presentation.JeuM2P;
import xml.metier2presentation.JoueurM2P;
import xml.metier2presentation.ListeJoueursM2P;
import xml.metier2presentation.ObjectFactory;
import xml.metier2presentation.PartieM2P;
import xml.metier2presentation.ReponseAvertirCommencerJeuM2P;

public class ReponseAvertirCommencerJeuM2PComportement{
	private JeuxMetierRetour jeuxMetier;
	
	public ReponseAvertirCommencerJeuM2PComportement(JeuxMetierRetour jeuxMetier){
		this.jeuxMetier = jeuxMetier;
	}
	
	public void envoiMessage() {
		ObjectFactory objFactory = new ObjectFactory();
		JeuM2P jeu = objFactory.createJeuM2P();
		System.out.println("jeuxMetier taille : "+jeuxMetier.getJeux().size());
		for(JeuMetierRetour unJeu : jeuxMetier.getJeux()){
			for(JoueurMetierRetour unJoueur : unJeu.getJoueurs().getJoueurs()){
				PartieM2P partie = objFactory.createPartieM2P();
				partie.setNomPartie(unJeu.getPartie().getNomPartie());
				partie.setNbJoueurPartie(unJeu.getPartie().getNbJoueurPartie());
				jeu.setPartie(partie);
				
				ListeJoueursM2P listeJoueurs = objFactory.createListeJoueursM2P();
				for(JoueurMetierRetour unJoueur2 : unJeu.getJoueurs().getJoueurs()){
					JoueurM2P joueur = objFactory.createJoueurM2P();
					joueur.setLoginJoueur(unJoueur2.getLoginJoueur());
					listeJoueurs.getListeJoueurs().add(joueur);
				}
				jeu.setListeJoueurs(listeJoueurs);
				
				ReponseAvertirCommencerJeuM2P reponseAvertirCommencerJeuM2P = objFactory.createReponseAvertirCommencerJeuM2P();
				reponseAvertirCommencerJeuM2P.setJeu(jeu);
				
				new Producteur(reponseAvertirCommencerJeuM2P, unJoueur.getNumeroPresentation());
			}
		}
	}

	public JeuxMetierRetour getJeuxMetier() {
		return jeuxMetier;
	}

	public void setJeuxMetier(JeuxMetierRetour jeuxMetier) {
		this.jeuxMetier = jeuxMetier;
	}
}