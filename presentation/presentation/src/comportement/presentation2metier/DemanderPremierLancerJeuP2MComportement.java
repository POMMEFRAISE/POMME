package comportement.presentation2metier;

import activeMQ.Producteur;
import model.Jeu;
import model.Joueur;
import xml.presentation2metier.DemanderPremierLancerJeuP2M;
import xml.presentation2metier.JeuP2M;
import xml.presentation2metier.JoueurP2M;
import xml.presentation2metier.ListeJoueursP2M;
import xml.presentation2metier.ObjectFactory;
import xml.presentation2metier.PartieP2M;

public class DemanderPremierLancerJeuP2MComportement{
	
	private Jeu jeu;
	private int numeroPresentation;
	public DemanderPremierLancerJeuP2MComportement(int numeroPresentation, Jeu jeu){
		this.jeu = jeu;
		this.numeroPresentation = numeroPresentation;
	}

	public void envoiMessage() {
		ObjectFactory objFactory = new ObjectFactory();
		JeuP2M jeuP2M = objFactory.createJeuP2M();
		
		PartieP2M partieP2M = objFactory.createPartieP2M();
		partieP2M.setNomPartie(jeu.getPartie().getNom());
		jeuP2M.setPartie(partieP2M);
		
		ListeJoueursP2M listeJoueursP2M = objFactory.createListeJoueursP2M();
		for(Joueur unJoueur : jeu.getJoueurs().getJoueurs()){
			JoueurP2M joueurP2M = objFactory.createJoueurP2M();
			joueurP2M.setLoginJoueur(unJoueur.getLogin());
			joueurP2M.setDoitJoueur(unJoueur.isDoitJouer());
			joueurP2M.setResultatPremierLancer(unJoueur.getResultatPremierLancer());
			joueurP2M.setPositionJeu(unJoueur.getPositionJeu());
			joueurP2M.setNumeroPresentation(unJoueur.getNumeroPresentation());
			
			JoueurP2M joueurGauche = objFactory.createJoueurP2M();
			joueurGauche.setLoginJoueur(unJoueur.getJoueurGauche().getLogin());
			joueurP2M.setJoueurGauche(joueurGauche);
			
			JoueurP2M joueurDroite = objFactory.createJoueurP2M();
			joueurDroite.setLoginJoueur(unJoueur.getJoueurDroite().getLogin());
			joueurP2M.setJoueurDroite(joueurDroite);
			
			listeJoueursP2M.getListeJoueurs().add(joueurP2M);
		}
		jeuP2M.setListeJoueurs(listeJoueursP2M);
		
		DemanderPremierLancerJeuP2M demanderPremierLancerJeu = objFactory.createDemanderPremierLancerJeuP2M();
		demanderPremierLancerJeu.setJeu(jeuP2M);
		demanderPremierLancerJeu.setNumeroPresentation(numeroPresentation);
		
		Thread thread = new Thread(new Producteur(demanderPremierLancerJeu));
		thread.start();
	}

	public int getNumeroPresentation() {
		return numeroPresentation;
	}

	public void setNumeroPresentation(int numeroPresentation) {
		this.numeroPresentation = numeroPresentation;
	}
}