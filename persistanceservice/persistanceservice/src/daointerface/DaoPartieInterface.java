package daointerface;

import entites.JoueurEntite;
import entites.PartieEntite;
import entites.PartiesEntite;

public interface DaoPartieInterface{
	PartieEntite recupererPartie (PartieEntite partie);
	boolean verifierPartie  (String nompartie);
	boolean creerPartie (PartieEntite partie);
	boolean rejoindrePartie(PartieEntite partie, JoueurEntite joueur, Integer numeroPresentation);
	String afficherEtatPartie (String nompartie);
	boolean fermerPartie (PartieEntite partie);
	PartiesEntite recupererListeParties();
	boolean verifierPartieRejoindre  (String nompartie);
}