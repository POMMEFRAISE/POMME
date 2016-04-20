package daointerface;

public interface DaoComandeInterface {
	boolean enregistrerComande (String message);
	
	boolean demanderAuthentification (String message);

}
