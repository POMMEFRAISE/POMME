package dao;

import entites.JoueurEntite;

public interface JoueurDAOInterface {
	JoueurEntite recupererJoueur (JoueurEntite joueur);
	boolean verificationJoueur (String login, String motdepasse);
}