package comportement.metier2presentation;

import comportement.Commande;
import model.De;
import model.Des;
import model.Jeu;
import model.Joueur;
import model.Joueurs;
import model.Partie;
import xml.metier2presentation.DeM2P;
import xml.metier2presentation.JoueurM2P;
import xml.metier2presentation.ReponseDemanderPremierLancerJeuM2P;

public class ReponseDemanderPremierLancerJeuM2PComportement implements Commande{
	private ReponseDemanderPremierLancerJeuM2P reponseDemanderPremierLancerJeuM2P;
	
	public ReponseDemanderPremierLancerJeuM2PComportement(ReponseDemanderPremierLancerJeuM2P reponseDemanderPremierLancerJeuM2P){
		this.reponseDemanderPremierLancerJeuM2P = reponseDemanderPremierLancerJeuM2P;
	}
	
	public Object reçoiMessage() {
		boolean dejaLance = false;
		Jeu jeu = new Jeu();
		
		Partie partie = new Partie();
		partie.setNom(reponseDemanderPremierLancerJeuM2P.getJeu().getPartie().getNomPartie());
		jeu.setPartie(partie);
		
		Joueurs listeJoueurs = new Joueurs();
		for(JoueurM2P unJoueur : reponseDemanderPremierLancerJeuM2P.getJeu().getListeJoueurs().getListeJoueurs()){
			Joueur joueur = new Joueur();
			joueur.setLogin(unJoueur.getLoginJoueur());
			joueur.setDoitJouer(unJoueur.isDoitJoueur());
			joueur.setPositionJeu(unJoueur.getPositionJeu());
			joueur.setResultatPremierLancer(unJoueur.getResultatPremierLancer());
			joueur.setNumeroPresentation(unJoueur.getNumeroPresentation());
			
			Joueur joueurGauche = new Joueur();
			joueurGauche.setLogin(unJoueur.getJoueurGauche().getLoginJoueur());
			joueur.setJoueurGauche(joueurGauche);
			
			Joueur joueurDroite = new Joueur();
			joueurDroite.setLogin(unJoueur.getJoueurDroite().getLoginJoueur());
			joueur.setJoueurDroite(joueurDroite);
			
			listeJoueurs.add(joueur);
		}
		
		int max = 0;
		for(Joueur unJoueur2 : listeJoueurs.getJoueurs()){
			if(unJoueur2.getResultatPremierLancer() != 0){
				dejaLance = true;
				if(unJoueur2.getResultatPremierLancer() > max){
					max = unJoueur2.getResultatPremierLancer();
				}
			}else{
				dejaLance = false;
			}
		}
		
		if(dejaLance == true){
			for(Joueur unJoueur3 : listeJoueurs.getJoueurs()){
				if(unJoueur3.getResultatPremierLancer() == max){
					unJoueur3.setDoitJouer(true);
				}
			}
		}

		jeu.setJoueurs(listeJoueurs);
		
		Des listeDes = new Des();
		int identifiantDe = 0;
		for(DeM2P unDe : reponseDemanderPremierLancerJeuM2P.getJeu().getListeDes().getListeDes()){
			identifiantDe = identifiantDe +1;
			De de = new De();
			de.setIdentifiant(identifiantDe);
			de.setValeur(unDe.getResultatDe());
			de.associerImage();
			listeDes.add(de);
		}
		jeu.setDes(listeDes);
		
		if(reponseDemanderPremierLancerJeuM2P.getCommande().isEnregistrer() == false){
			jeu.setMessage("En raison d'un problème technique, la partie à du être fermée !");
		}else{
			jeu.setMessage("");
		}
		return jeu;
	}

	public ReponseDemanderPremierLancerJeuM2P getReponseDemanderPremierLancerJeuM2P() {
		return reponseDemanderPremierLancerJeuM2P;
	}

	public void setReponseDemanderPremierLancerJeuM2P(ReponseDemanderPremierLancerJeuM2P reponseDemanderPremierLancerJeuM2P) {
		this.reponseDemanderPremierLancerJeuM2P = reponseDemanderPremierLancerJeuM2P;
	}
}