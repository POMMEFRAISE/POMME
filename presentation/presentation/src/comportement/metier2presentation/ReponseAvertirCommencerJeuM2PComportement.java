package comportement.metier2presentation;

import comportement.Commande;
import model.Jeu;
import model.Joueur;
import model.Joueurs;
import model.Partie;
import xml.metier2presentation.JoueurM2P;
import xml.metier2presentation.ReponseAvertirCommencerJeuM2P;

public class ReponseAvertirCommencerJeuM2PComportement implements Commande{
	private ReponseAvertirCommencerJeuM2P reponseAvertirCommencerJeuM2P;
	private Jeu jeu = new Jeu();
	
	public ReponseAvertirCommencerJeuM2PComportement(ReponseAvertirCommencerJeuM2P reponseAvertirCommencerJeuM2P){
		this.reponseAvertirCommencerJeuM2P = reponseAvertirCommencerJeuM2P;
	}

	public Jeu reçoiMessage() {
		Partie partie = new Partie();
		partie.setNom(reponseAvertirCommencerJeuM2P.getJeu().getPartie().getNomPartie());
		
		Joueurs listeJoueurs = new Joueurs();
		
		for(JoueurM2P unJoueur : reponseAvertirCommencerJeuM2P.getJeu().getListeJoueurs().getListeJoueurs()){
			Joueur joueur = new Joueur();
			joueur.setLogin(unJoueur.getLoginJoueur());
			listeJoueurs.add(joueur);
		}
		
		jeu.setPartie(partie);
		jeu.setJoueurs(listeJoueurs);
		
		return verifierInformations();
	}
	
	public Jeu verifierInformations(){
		String messageErreur = "";
		if(jeu.getJoueurs().getTaille() == 0){
			messageErreur = "Désolé mais la partie n'a pas requis le nombre jouer minimum nécessaire pour commencer !";
			messageErreur = messageErreur +"\n Vous pouvez choisir une autre partie ou en créer une nouvelle !";
			jeu.setMessage(messageErreur);
			jeu.setStatut(false);
		}else{
			jeu.setStatut(true);
		}
		return jeu;
	}
}