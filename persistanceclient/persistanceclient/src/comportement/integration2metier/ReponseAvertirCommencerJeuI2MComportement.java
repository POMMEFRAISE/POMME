package comportement.integration2metier;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import activeMQ.Producteur;
import xml.integration2metier.JeuI2M;
import xml.integration2metier.JoueurI2M;
import xml.integration2metier.ListeJeuxI2M;
import xml.integration2metier.ListeJoueursI2M;
import xml.integration2metier.ObjectFactory;
import xml.integration2metier.PartieI2M;
import xml.integration2metier.ReponseAvertirCommencerJeuI2M;

public class ReponseAvertirCommencerJeuI2MComportement{
	private ArrayList<Object> listeJeuxDTO;
	
	public ReponseAvertirCommencerJeuI2MComportement(ArrayList<Object> listeJeuxDTO){
		this.listeJeuxDTO = listeJeuxDTO;
	}
	
	public void envoiMessage() {
		ObjectFactory objFactory = new ObjectFactory();
		ListeJeuxI2M jeux = objFactory.createListeJeuxI2M();
		
		for(Object unJeu : listeJeuxDTO){
			JeuI2M jeuI2M = objFactory.createJeuI2M();
			
			PartieI2M partie = objFactory.createPartieI2M();
			try {
				Object partieDTO = unJeu.getClass().getMethod("getPartie").invoke(unJeu);
				partie.setNomPartie(partieDTO.getClass().getMethod("getNomPartie").invoke(partieDTO).toString());
				
				Object listeJoueurs  = unJeu.getClass().getMethod("getJoueurs").invoke(unJeu);

				ArrayList<Object> listeJoueursDTO = (ArrayList<Object>) (listeJoueurs.getClass().getMethod("getJoueurs").invoke(listeJoueurs));
				
				ListeJoueursI2M joueurs = objFactory.createListeJoueursI2M();
				for(Object unJoueur : listeJoueursDTO){
					JoueurI2M joueur = objFactory.createJoueurI2M();
					joueur.setLoginJoueur(unJoueur.getClass().getMethod("getLogin").invoke(unJoueur).toString());
					joueur.setNumeroPresentation((Integer) unJoueur.getClass().getMethod("getNumeroPresentation").invoke(unJoueur));
					joueurs.getListeJoueurs().add(joueur);
				}
				jeuI2M.setPartie(partie);
				jeuI2M.setJoueurs(joueurs);
				
				jeux.getListeJeux().add(jeuI2M);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
					| SecurityException e) {
				e.printStackTrace();
			}
		}
		
		ReponseAvertirCommencerJeuI2M reponseAvertirCommencerJeuI2M = objFactory.createReponseAvertirCommencerJeuI2M();
		reponseAvertirCommencerJeuI2M.setListeJeux(jeux);
		
		new Producteur(reponseAvertirCommencerJeuI2M);
	}
}