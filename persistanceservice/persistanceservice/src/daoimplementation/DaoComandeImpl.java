package daoimplementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import daointerface.DaoComandeInterface;
import daoparam.ConnexionDAO;

public class DaoComandeImpl implements DaoComandeInterface{
	private ResultSet resultat = null;
	public DaoComandeImpl(){
	}
	@Override
	public boolean enregistrerComande(String message) {
		
		return false;
	}
	
	public synchronized boolean demanderAuthentification(String message) {
		boolean bool = false;
		
		try {
			String demanderAuthentificationSQL = ConnexionDAO.getProperties().getProperty("demanderAuthentificationSQL");
			PreparedStatement preparedStatement = ConnexionDAO.getInstance().prepareCall(demanderAuthentificationSQL);
			preparedStatement.setString(1, message);
			int resultat = preparedStatement.executeUpdate();
			
			if (resultat>=1) {
				bool= true;
				return bool;
			}else {
				bool= false;
				return bool;
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bool;
	}

}
