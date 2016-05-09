package comportement.metier2presentation;

import activeMQ.Producteur;
import model.DeMetierRetour;
import model.DesMetierRetour;
import model.JeuMetierRetour;
import model.JoueurMetierRetour;
import xml.metier2presentation.CommandeM2P;
import xml.metier2presentation.DeM2P;
import xml.metier2presentation.JeuM2P;
import xml.metier2presentation.JoueurM2P;
import xml.metier2presentation.ListeDesM2P;
import xml.metier2presentation.ListeJoueursM2P;
import xml.metier2presentation.ObjectFactory;
import xml.metier2presentation.PartieM2P;
import xml.metier2presentation.ReponseDemanderPremierLancerJeuM2P;

public class ReponseDemanderPremierLancerJeuM2PComportement{
	private JeuMetierRetour jeuMetier;
	private int numeroPresentation;
	private boolean commandeEnregistrer;
	private DesMetierRetour listeDes = new DesMetierRetour();

	public ReponseDemanderPremierLancerJeuM2PComportement(JeuMetierRetour jeuMetier, int numeroPresentation, boolean commandeEnregistrer){
		this.jeuMetier = jeuMetier;
		this.numeroPresentation = numeroPresentation;
		this.commandeEnregistrer = commandeEnregistrer;
	}
	
	public void envoiMessage() {
		int resultatLancer = 0;
		lancerDes();
		for(DeMetierRetour unDe : listeDes.getDes()){
			resultatLancer = resultatLancer + unDe.getResultatDe();
		}
		
		for(JoueurMetierRetour unJoueur : jeuMetier.getJoueurs().getJoueurs()){			
			ObjectFactory objFactory = new ObjectFactory();
			JeuM2P jeu = objFactory.createJeuM2P();
			PartieM2P partie = objFactory.createPartieM2P();
			partie.setNomPartie(jeuMetier.getPartie().getNomPartie());
			jeu.setPartie(partie);
			
			int positionJoueurLancer = 0;
			ListeJoueursM2P listeJoueurs = objFactory.createListeJoueursM2P();
			for(JoueurMetierRetour unJoueur2 : jeuMetier.getJoueurs().getJoueurs()){
				JoueurM2P joueur = objFactory.createJoueurM2P();
				joueur.setLoginJoueur(unJoueur2.getLoginJoueur());
				joueur.setPositionJeu(unJoueur2.getPositionJeu());
				joueur.setNumeroPresentation(unJoueur2.getNumeroPresentation());
				if(unJoueur2.isDoitJouer() == true){
					joueur.setDoitJoueur(false);
					joueur.setResultatPremierLancer(resultatLancer);
					positionJoueurLancer = unJoueur2.getPositionJeu();
				}else{
					joueur.setResultatPremierLancer(0);
					if((unJoueur2.getPositionJeu()-1) == positionJoueurLancer){
						joueur.setDoitJoueur(true);
					}else{
						joueur.setDoitJoueur(false);
					}
				}
				
				JoueurM2P joueurGauche = objFactory.createJoueurM2P();
				joueurGauche.setLoginJoueur(unJoueur2.getJoueurGauche().getLoginJoueur());

				JoueurM2P joueurDroite = objFactory.createJoueurM2P();
				joueurDroite.setLoginJoueur(unJoueur2.getJoueurDroite().getLoginJoueur());

				joueur.setJoueurGauche(joueurGauche);
				joueur.setJoueurDroite(joueurDroite);
					
				listeJoueurs.getListeJoueurs().add(joueur);
				jeu.setListeJoueurs(listeJoueurs);
			}
			
			ListeDesM2P listeDesM2P = objFactory.createListeDesM2P();
			for(DeMetierRetour unDe : listeDes.getDes()){
				DeM2P deM2P  = objFactory.createDeM2P();
				deM2P.setResultatDe(unDe.getResultatDe());
				listeDesM2P.getListeDes().add(deM2P);
			}
			jeu.setListeDes(listeDesM2P);
			
			if(resultatLancer != 0){
				commandeEnregistrer = true;
			}else{
				commandeEnregistrer = false;
			}
			
			ReponseDemanderPremierLancerJeuM2P reponseDemanderPremierLancerJeuM2P = objFactory.createReponseDemanderPremierLancerJeuM2P();
			reponseDemanderPremierLancerJeuM2P.setJeu(jeu);
			
			CommandeM2P commande = objFactory.createCommandeM2P();
			commande.setEnregistrer(commandeEnregistrer);
			reponseDemanderPremierLancerJeuM2P.setCommande(commande);
			new Producteur(reponseDemanderPremierLancerJeuM2P, unJoueur.getNumeroPresentation());
		}
		
	}

	public JeuMetierRetour getJeuMetier() {
		return jeuMetier;
	}

	public void setJeuMetier(JeuMetierRetour jeuMetier) {
		this.jeuMetier = jeuMetier;
	}

	public int getNumeroPresentation() {
		return numeroPresentation;
	}

	public void setNumeroPresentation(int numeroPresentation) {
		this.numeroPresentation = numeroPresentation;
	}

	public boolean isCommandeEnregistrer() {
		return commandeEnregistrer;
	}

	public void setCommandeEnregistrer(boolean commandeEnregistrer) {
		this.commandeEnregistrer = commandeEnregistrer;
	}
	
	public void lancerDes(){
	    for (int idx = 1; idx <= 5; ++idx){
	      int resultat = (int) (Math.random() * (6 + 1 - 1)) + 1;

	      DeMetierRetour unDe = new DeMetierRetour(resultat);
	      listeDes.add(unDe);
	      System.out.println("unDe : "+unDe.getResultatDe());
	    }
	}

	public DesMetierRetour getListeDes() {
		return listeDes;
	}

	public void setListeDes(DesMetierRetour listeDes) {
		this.listeDes = listeDes;
	}
}