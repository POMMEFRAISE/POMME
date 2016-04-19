package daointerface;

import entites.JoueurEntite;

public interface DaoJoueurInterface {
	JoueurEntite recupererJoueur (JoueurEntite joueur);
	boolean verifierJoueur (String login, String motdepasse);
	boolean creerCompte (JoueurEntite joueur);
	boolean gererProfil (JoueurEntite joueur);
	
}