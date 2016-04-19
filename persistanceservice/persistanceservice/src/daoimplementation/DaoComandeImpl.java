package daoimplementation;

import java.sql.ResultSet;

import daointerface.DaoComandeInterface;

public class DaoComandeImpl implements DaoComandeInterface{
	private ResultSet resultat = null;
	public DaoComandeImpl(){
	}
	@Override
	public boolean enregistrerComande(String message) {
		
		return false;
	}

}
