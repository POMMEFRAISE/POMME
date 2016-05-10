package comportement.metier2integration;

import activeMQ.Producteur;
import model.JeuMetierAller;
import model.JoueurMetierAller;
import xml.metier2integration.DemanderPremierLancerJeuM2I;
import xml.metier2integration.JeuM2I;
import xml.metier2integration.JoueurM2I;
import xml.metier2integration.ListeJoueursM2I;
import xml.metier2integration.ObjectFactory;
import xml.metier2integration.PartieM2I;


public class DemanderPremierLancerJeuM2IComportement{
	
	private JeuMetierAller jeu;
	private int numeroPresentation;
	public DemanderPremierLancerJeuM2IComportement(JeuMetierAller jeu, int numeroPresentation){
		this.jeu = jeu;
		this.numeroPresentation = numeroPresentation;
	}
	
	public void envoiMessage(){
		ObjectFactory objFactory = new ObjectFactory();
		JeuM2I jeuM2I = objFactory.createJeuM2I();
		
		PartieM2I partieM2I = objFactory.createPartieM2I();
		partieM2I.setNomPartie(jeu.getPartie().getNomPartie());
		jeuM2I.setPartie(partieM2I);
		
		ListeJoueursM2I listeJoueursM2I = objFactory.createListeJoueursM2I();
		for(JoueurMetierAller unJoueur : jeu.getJoueurs().getJoueurs()){
			JoueurM2I joueurM2I = objFactory.createJoueurM2I();
			joueurM2I.setLoginJoueur(unJoueur.getLoginJoueur());
			joueurM2I.setDoitJoueur(unJoueur.isDoitJouer());
			joueurM2I.setResultatPremierLancer(unJoueur.getResultatPremierLancer());
			joueurM2I.setPositionJeu(unJoueur.getPositionJeu());
			joueurM2I.setNumeroPresentation(unJoueur.getNumeroPresentation());
			
			JoueurM2I joueurGauche = objFactory.createJoueurM2I();
			joueurGauche.setLoginJoueur(unJoueur.getJoueurGauche().getLoginJoueur());
			joueurM2I.setJoueurGauche(joueurGauche);
			
			JoueurM2I joueurDroite = objFactory.createJoueurM2I();
			joueurDroite.setLoginJoueur(unJoueur.getJoueurDroite().getLoginJoueur());
			joueurM2I.setJoueurDroite(joueurDroite);
			
			listeJoueursM2I.getListeJoueurs().add(joueurM2I);
		}
		jeuM2I.setListeJoueurs(listeJoueursM2I);
		
		DemanderPremierLancerJeuM2I demanderPremierLancerJeu = objFactory.createDemanderPremierLancerJeuM2I();
		demanderPremierLancerJeu.setJeu(jeuM2I);
		demanderPremierLancerJeu.setNumeroPresentation(numeroPresentation);
		
		Thread thread = new Thread(new Producteur(demanderPremierLancerJeu));
		thread.start();
	}

	public JeuMetierAller getJeu() {
		return jeu;
	}

	public void setJeu(JeuMetierAller jeu) {
		this.jeu = jeu;
	}

	public int getNumeroPresentation() {
		return numeroPresentation;
	}

	public void setNumeroPresentation(int numeroPresentation) {
		this.numeroPresentation = numeroPresentation;
	}
}