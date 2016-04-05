package daoInterface;

import entites.JoueurEntite;

public interface DaoJoueurInterface {
	JoueurEntite recupererJoueur (JoueurEntite joueur);
	boolean verificationJoueur (String login, String motdepasse);
	
}