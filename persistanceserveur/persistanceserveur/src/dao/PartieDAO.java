package dao;

import java.sql.ResultSet;

public class PartieDAO implements PartieDAOInterface{
	private ResultSet resultat = null;
	
	public PartieDAO(){
		RecupererRequete.recupererRequete();
	}
	
	public boolean rejoindrePartie(String nompartie, int nbrejoueur)  {
	
		return false;
	}
}