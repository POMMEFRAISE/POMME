package daointerface;

import entites.PartieEntite;

public interface DaoPartieInterface{
	PartieEntite recupererPartie (PartieEntite partie);
	boolean verifierPartie  (String nompartie);
	boolean creerPartie (PartieEntite partie);
	boolean rejoindrePartie(PartieEntite partie);
	String afficherEtatPartie (String nompartie);
	boolean fermerPartie (PartieEntite partie);
}