package comportement.commun;

import java.util.ArrayList;

public class DeComportement {

	public int valeur;

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public int min = 1;
	public int max = 6;

	// lancement du dé au hasard
	public void lancer() {
		valeur = (int) (Math.random() * (max + 1 - min)) + min;

	}

	// liste des dés
	public static ArrayList<DeComportement> lesDes = new ArrayList<DeComportement>();
	// liste des joueurs
	public static ArrayList<JoueurComportement> lesJoueurs = new ArrayList<JoueurComportement>();
	
	public static int sommeDes;

	public static int getSommeDes() {
		return sommeDes;
	}
	public static void setSommeDes(int sommeDes) {
		DeComportement.sommeDes = sommeDes;
	}
}
