package comportement.integration2metier;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import activeMQ.Producteur;
import xml.integration2metier.CommandeI2M;
import xml.integration2metier.JeuI2M;
import xml.integration2metier.JoueurI2M;
import xml.integration2metier.ListeJoueursI2M;
import xml.integration2metier.ObjectFactory;
import xml.integration2metier.PartieI2M;
import xml.integration2metier.ReponseDemanderPremierLancerJeuI2M;

public class ReponseDemanderPremierLancerJeuI2MComportement{
	private int numeroPresentation;
	private boolean enregistrerCommande;
	private Object objectJeu;
	
	public ReponseDemanderPremierLancerJeuI2MComportement(boolean enregistrerCommande, int numeroPresentation, Object objectJeu){
		this.numeroPresentation = numeroPresentation;
		this.enregistrerCommande = enregistrerCommande;
		this.objectJeu = objectJeu;
	}

	public void envoiMessage() {
		ObjectFactory objFactory = new ObjectFactory();
		JeuI2M jeuI2M = objFactory.createJeuI2M();
		PartieI2M partie = objFactory.createPartieI2M();
		
		try {
			Object partieDTO = objectJeu.getClass().getMethod("getPartie").invoke(objectJeu);
			partie.setNomPartie(partieDTO.getClass().getMethod("getNomPartie").invoke(partieDTO).toString());
			
			Object listeJoueurs  = objectJeu.getClass().getMethod("getJoueurs").invoke(objectJeu);
			ArrayList<Object> listeJoueursDTO = (ArrayList<Object>) (listeJoueurs.getClass().getMethod("getJoueurs").invoke(listeJoueurs));
			ListeJoueursI2M joueurs = objFactory.createListeJoueursI2M();
			for(Object unJoueur : listeJoueursDTO){
				JoueurI2M joueur = objFactory.createJoueurI2M();
				joueur.setLoginJoueur(unJoueur.getClass().getMethod("getLogin").invoke(unJoueur).toString());
				joueur.setNumeroPresentation((Integer) unJoueur.getClass().getMethod("getNumeroPresentation").invoke(unJoueur));
				joueur.setPositionJeu((Integer) unJoueur.getClass().getMethod("getPositionJeu").invoke(unJoueur));
				joueur.setResultatPremierLancer((Integer) unJoueur.getClass().getMethod("getResultatPremierLancer").invoke(unJoueur));
				joueur.setDoitJoueur((boolean) unJoueur.getClass().getMethod("isDoitJouer").invoke(unJoueur));

				JoueurI2M joueurGauche = objFactory.createJoueurI2M();
				Object objectJoueurGauche  = unJoueur.getClass().getMethod("getJoueurGauche").invoke(unJoueur);
				joueurGauche.setLoginJoueur(objectJoueurGauche.getClass().getDeclaredMethod("getLogin").invoke(objectJoueurGauche).toString());

				JoueurI2M joueurDroite = objFactory.createJoueurI2M();
				Object objectJoueurDroite  = unJoueur.getClass().getMethod("getJoueurDroite").invoke(unJoueur);
				joueurDroite.setLoginJoueur(objectJoueurDroite.getClass().getDeclaredMethod("getLogin").invoke(objectJoueurDroite).toString());

				joueur.setJoueurGauche(joueurGauche);
				joueur.setJoueurDroite(joueurDroite);
				
				joueurs.getListeJoueurs().add(joueur);
				System.out.println("Joeuur DTO : "+joueur.getLoginJoueur());
			}
			jeuI2M.setPartie(partie);
			jeuI2M.setJoueurs(joueurs);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			e.printStackTrace();
		}
		ReponseDemanderPremierLancerJeuI2M reponseDemanderPremierLancerJeu = objFactory.createReponseDemanderPremierLancerJeuI2M();
		reponseDemanderPremierLancerJeu.setJeu(jeuI2M);
		reponseDemanderPremierLancerJeu.setNumeroPresentation(numeroPresentation);
		
		CommandeI2M commande = objFactory.createCommandeI2M();
		commande.setEnregistrer(enregistrerCommande);
		reponseDemanderPremierLancerJeu.setCommande(commande);
		new Producteur(reponseDemanderPremierLancerJeu);

	}

	public Object getObjectJeu() {
		return objectJeu;
	}

	public void setObjectJeu(Object objectJeu) {
		this.objectJeu = objectJeu;
	}

	public boolean isEnregistrerCommande() {
		return enregistrerCommande;
	}

	public void setEnregistrerCommande(boolean enregistrerCommande) {
		this.enregistrerCommande = enregistrerCommande;
	}
}