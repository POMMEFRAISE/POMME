package daointerface;

import entites.PartieEntite;

public interface DaoPartieInterface{
	PartieEntite recupererPartie (PartieEntite partie);
	boolean creerPartieSQL (PartieEntite partie);
	boolean rejoindrePartie(PartieEntite partie);
	String afficherEtatPartie (String nompartie);
	boolean fermerPartieSQL (PartieEntite partie);
}