package lanceur;

import activeMQ.Lecteur;

public class Lanceur {
	public static void main(String[] args) {
		Lecteur lecteur = new Lecteur(false);
		Thread thread = new Thread(lecteur);
		thread.start();
	}
}