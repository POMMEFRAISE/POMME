package comportement.integration2metier;

import comportement.Commande;
import comportement.metier2presentation.ReponseDemanderPremierLancerJeuM2PComportement;
import model.JeuMetierRetour;
import model.JoueurMetierRetour;
import model.JoueursMetierRetour;
import model.PartieMetierRetour;
import xml.integration2metier.JoueurI2M;
import xml.integration2metier.ReponseDemanderPremierLancerJeuI2M;


public class ReponseDemanderPremierLancerJeuI2MComportement implements Commande{
	private ReponseDemanderPremierLancerJeuI2M reponseDemanderPremierLancerJeuI2M;
	
	public ReponseDemanderPremierLancerJeuI2MComportement(ReponseDemanderPremierLancerJeuI2M reponseDemanderPremierLancerJeuI2M){
		this.reponseDemanderPremierLancerJeuI2M = reponseDemanderPremierLancerJeuI2M;
	}
	
	public void reçoiMessage() {
		JeuMetierRetour jeu = new JeuMetierRetour();
		
		PartieMetierRetour partie = new PartieMetierRetour();
		partie.setNomPartie(reponseDemanderPremierLancerJeuI2M.getJeu().getPartie().getNomPartie());
		jeu.setPartie(partie);
		
		JoueursMetierRetour listeJoueurs = new JoueursMetierRetour();
		for(JoueurI2M unJoueur : reponseDemanderPremierLancerJeuI2M.getJeu().getJoueurs().getListeJoueurs()){
			JoueurMetierRetour joueur = new JoueurMetierRetour();
			joueur.setLoginJoueur(unJoueur.getLoginJoueur());
			joueur.setDoitJouer(unJoueur.isDoitJoueur());
			joueur.setPositionJeu(unJoueur.getPositionJeu());
			joueur.setResultatPremierLancer(unJoueur.getResultatPremierLancer());
			joueur.setNumeroPresentation(unJoueur.getNumeroPresentation());
			
			JoueurMetierRetour joueurGauche = new JoueurMetierRetour();
			joueurGauche.setLoginJoueur(unJoueur.getJoueurGauche().getLoginJoueur());
			joueur.setJoueurGauche(joueurGauche);
			
			JoueurMetierRetour joueurDroite = new JoueurMetierRetour();
			joueurDroite.setLoginJoueur(unJoueur.getJoueurDroite().getLoginJoueur());
			joueur.setJoueurDroite(joueurDroite);
			
			listeJoueurs.add(joueur);
		}
		jeu.setJoueurs(listeJoueurs);
		
		ReponseDemanderPremierLancerJeuM2PComportement reponseDemanderPremierLancerJeuM2PComportement = 
				new ReponseDemanderPremierLancerJeuM2PComportement(jeu, 
						reponseDemanderPremierLancerJeuI2M.getNumeroPresentation(), 
						reponseDemanderPremierLancerJeuI2M.getCommande().isEnregistrer());
		reponseDemanderPremierLancerJeuM2PComportement.envoiMessage();	
	}

	public ReponseDemanderPremierLancerJeuI2M getReponseDemanderPremierLancerJeuI2M() {
		return reponseDemanderPremierLancerJeuI2M;
	}

	public void setReponseDemanderPremierLancerJeuI2M(ReponseDemanderPremierLancerJeuI2M reponseDemanderPremierLancerJeuI2M) {
		this.reponseDemanderPremierLancerJeuI2M = reponseDemanderPremierLancerJeuI2M;
	}
}