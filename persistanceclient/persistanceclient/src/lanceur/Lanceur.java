package lanceur;

import activeMQ.Lecteur;

public class Lanceur {
	public static void main(String[] args) {
        Thread thread = new Thread(new Lecteur());
        thread.start();	
	}
}