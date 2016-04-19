package model;

import java.util.ArrayList;

public class DePresentation {

	public int valeur;

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public int min = 1;
	public int max = 6;

	// lancement du d� au hasard
	public void lancer() {
		valeur = (int) (Math.random() * (max + 1 - min)) + min;

	}

	// liste des d�s
	public static ArrayList<DePresentation> lesDes = new ArrayList<DePresentation>();
	// liste des joueurs
	public static ArrayList<JoueurPresentation> lesJoueurs = new ArrayList<JoueurPresentation>();
	
	public static int sommeDes;

	public static int getSommeDes() {
		return sommeDes;
	}
	public static void setSommeDes(int sommeDes) {
		DePresentation.sommeDes = sommeDes;
	}
}
