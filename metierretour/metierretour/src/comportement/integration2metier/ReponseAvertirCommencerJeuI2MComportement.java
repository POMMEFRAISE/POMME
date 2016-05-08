package comportement.integration2metier;

import comportement.Commande;
import comportement.metier2presentation.ReponseAvertirCommencerJeuM2PComportement;
import model.JeuMetierRetour;
import model.JeuxMetierRetour;
import model.JoueurMetierRetour;
import model.JoueursMetierRetour;
import model.PartieMetierRetour;
import xml.integration2metier.JeuI2M;
import xml.integration2metier.JoueurI2M;
import xml.integration2metier.ReponseAvertirCommencerJeuI2M;

public class ReponseAvertirCommencerJeuI2MComportement implements Commande{
	private ReponseAvertirCommencerJeuI2M reponseAvertirCommencerJeuI2M;

	public ReponseAvertirCommencerJeuI2MComportement(ReponseAvertirCommencerJeuI2M reponseAvertirCommencerJeuI2M){
		this.reponseAvertirCommencerJeuI2M = reponseAvertirCommencerJeuI2M;
	}

	public void reçoiMessage() {
		JeuxMetierRetour listeJeux = new JeuxMetierRetour();
		for(JeuI2M unJeu : reponseAvertirCommencerJeuI2M.getListeJeux().getListeJeux()){
			JeuMetierRetour jeu = new JeuMetierRetour();
			
			PartieMetierRetour partie = new PartieMetierRetour();
			partie.setNomPartie(unJeu.getPartie().getNomPartie());
			partie.setNbJoueurPartie(unJeu.getPartie().getNbJoueurPartie());
			for(JoueurI2M unJoueur : unJeu.getJoueurs().getListeJoueurs()){
				JoueurMetierRetour joueur = new JoueurMetierRetour();
				joueur.setLoginJoueur(unJoueur.getLoginJoueur());
				joueur.setNumeroPresentation(unJoueur.getNumeroPresentation());
				joueur.setPositionJeu(unJoueur.getPositionJeu());
				jeu.getJoueurs().add(joueur);
			}
			jeu.setPartie(partie);
			listeJeux.add(jeu);
		}
		
		ReponseAvertirCommencerJeuM2PComportement reponseAvertirCommencerJeuM2P = new ReponseAvertirCommencerJeuM2PComportement(listeJeux);

		reponseAvertirCommencerJeuM2P.envoiMessage();
	}

	public ReponseAvertirCommencerJeuI2M getReponseAvertirCommencerJeuI2M() {
		return reponseAvertirCommencerJeuI2M;
	}

	public void setReponseAvertirCommencerJeuI2M(ReponseAvertirCommencerJeuI2M reponseAvertirCommencerJeuI2M) {
		this.reponseAvertirCommencerJeuI2M = reponseAvertirCommencerJeuI2M;
	}
}