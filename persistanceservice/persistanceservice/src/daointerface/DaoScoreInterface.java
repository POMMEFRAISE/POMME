package daointerface;

import entites.JoueurEntite;
import entites.PartieEntite;

public interface  DaoScoreInterface {

	String ConsulterScore(JoueurEntite idJoueur,PartieEntite idPartie);
}
