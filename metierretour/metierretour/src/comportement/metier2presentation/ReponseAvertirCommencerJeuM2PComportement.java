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

		for(JeuMetierRetour unJeu : jeuxMetier.getJeux()){
			ObjectFactory objFactory = new ObjectFactory();
			JeuM2P jeu = objFactory.createJeuM2P();
			for(JoueurMetierRetour unJoueur : unJeu.getJoueurs().getJoueurs()){
				PartieM2P partie = objFactory.createPartieM2P();
				partie.setNomPartie(unJeu.getPartie().getNomPartie());
				partie.setNbJoueurPartie(unJeu.getPartie().getNbJoueurPartie());
				jeu.setPartie(partie);
				
				ListeJoueursM2P listeJoueurs = objFactory.createListeJoueursM2P();
				for(JoueurMetierRetour unJoueur2 : unJeu.getJoueurs().getJoueurs()){
					JoueurM2P joueur = objFactory.createJoueurM2P();
					joueur.setLoginJoueur(unJoueur2.getLoginJoueur());
					joueur.setPositionJeu(unJoueur2.getPositionJeu());

					joueur.setResultatPremierLancer(0);
					
					JoueurM2P joueurGauche = objFactory.createJoueurM2P();
					for(JoueurMetierRetour unJoueurGauche : unJeu.getJoueurs().getJoueurs()){
						if((unJoueurGauche.getPositionJeu()-1) == unJoueur2.getPositionJeu()){
							joueurGauche.setLoginJoueur(unJoueurGauche.getLoginJoueur());
							break;
						}
					}

					JoueurM2P joueurDroite = objFactory.createJoueurM2P();
					for(JoueurMetierRetour unJoueurDroite : unJeu.getJoueurs().getJoueurs()){
						if((unJoueurDroite.getPositionJeu()+1) ==(unJoueur2.getPositionJeu())){
							joueurDroite.setLoginJoueur(unJoueurDroite.getLoginJoueur());
							break;
						}
					}
					
					if(joueurGauche.getLoginJoueur() == null){
						for(JoueurMetierRetour unJoueurGauche2 : unJeu.getJoueurs().getJoueurs()){
							if(!unJoueurGauche2.getLoginJoueur().equals(unJoueur2.getLoginJoueur()) &&
									!unJoueurGauche2.getLoginJoueur().equals(joueurDroite.getLoginJoueur())){
								joueurGauche.setLoginJoueur(unJoueurGauche2.getLoginJoueur());
								break;
							}			
						}
					}
					
					if(joueurDroite.getLoginJoueur() == null){
						for(JoueurMetierRetour unJoueurDroite2 : unJeu.getJoueurs().getJoueurs()){
							if(!unJoueurDroite2.getLoginJoueur().equals(unJoueur2.getLoginJoueur()) &&
									!unJoueurDroite2.getLoginJoueur().equals(joueurGauche.getLoginJoueur())){
								joueurDroite.setLoginJoueur(unJoueurDroite2.getLoginJoueur());
								break;
							}			
						}
					}
					
					joueur.setJoueurGauche(joueurGauche);
					joueur.setJoueurDroite(joueurDroite);

					if(unJoueur2.getPositionJeu() == 1){
						joueur.setDoitJoueur(true);
					}else{
						joueur.setDoitJoueur(false);
					}
					
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