package comportement.presentation2metier;

import comportement.Commande;
import comportement.metier2integration.DemanderPremierLancerJeuM2IComportement;
import model.JeuMetierAller;
import model.JoueurMetierAller;
import model.JoueursMetierAller;
import model.PartieMetierAller;
import xml.presentation2metier.DemanderPremierLancerJeuP2M;
import xml.presentation2metier.JoueurP2M;

public class DemanderPremierLancerJeuP2MComportement implements Commande{
	private DemanderPremierLancerJeuP2M demanderPremierLancerJeuP2M;
	
	public DemanderPremierLancerJeuP2MComportement(DemanderPremierLancerJeuP2M demanderPremierLancerJeuP2M){
		this.setDemanderPremierLancerJeuP2M(demanderPremierLancerJeuP2M);
	}
	
	public void reçoiMessage() {
		JeuMetierAller jeu = new JeuMetierAller();
		
		PartieMetierAller partie = new PartieMetierAller();
		partie.setNomPartie(demanderPremierLancerJeuP2M.getJeu().getPartie().getNomPartie());
		jeu.setPartie(partie);
		
		JoueursMetierAller listeJoueurs = new JoueursMetierAller();
		for(JoueurP2M unJoueur : demanderPremierLancerJeuP2M.getJeu().getListeJoueurs().getListeJoueurs()){
			JoueurMetierAller joueur = new JoueurMetierAller();
			joueur.setLoginJoueur(unJoueur.getLoginJoueur());
			joueur.setDoitJouer(unJoueur.isDoitJoueur());
			joueur.setPositionJeu(unJoueur.getPositionJeu());
			joueur.setResultatPremierLancer(unJoueur.getResultatPremierLancer());
			joueur.setNumeroPresentation(unJoueur.getNumeroPresentation());
			
			JoueurMetierAller joueurGauche = new JoueurMetierAller();
			joueurGauche.setLoginJoueur(unJoueur.getJoueurGauche().getLoginJoueur());
			joueur.setJoueurGauche(joueurGauche);
			
			JoueurMetierAller joueurDroite = new JoueurMetierAller();
			joueurDroite.setLoginJoueur(unJoueur.getJoueurDroite().getLoginJoueur());
			joueur.setJoueurDroite(joueurDroite);
			
			listeJoueurs.add(joueur);
		}
		jeu.setJoueurs(listeJoueurs);
		
		DemanderPremierLancerJeuM2IComportement demanderPremierLancerJeuM2IComportement = 
				new DemanderPremierLancerJeuM2IComportement(jeu, demanderPremierLancerJeuP2M.getNumeroPresentation());
		demanderPremierLancerJeuM2IComportement.envoiMessage();	
	}

	public DemanderPremierLancerJeuP2M getDemanderPremierLancerJeuP2M() {
		return demanderPremierLancerJeuP2M;
	}

	public void setDemanderPremierLancerJeuP2M(DemanderPremierLancerJeuP2M demanderPremierLancerJeuP2M) {
		this.demanderPremierLancerJeuP2M = demanderPremierLancerJeuP2M;
	}
}