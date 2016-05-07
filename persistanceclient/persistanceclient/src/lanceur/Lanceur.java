package lanceur;

import activeMQ.Lecteur;
import comportement.metier2integration.AvertirCommencerJeuM2IComportement;

public class Lanceur {
	public static void main(String[] args) {
		Lecteur lecteur = new Lecteur();
		Thread thread = new Thread(lecteur);
		thread.start();
		
		Thread thread2 = new Thread(new AvertirCommencerJeuM2IComportement());
		thread2.start();
	}
}