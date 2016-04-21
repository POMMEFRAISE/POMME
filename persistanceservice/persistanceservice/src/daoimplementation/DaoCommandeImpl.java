package daoimplementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import daointerface.DaoCommandeInterface;
import daoparam.ConnexionDAO;
import entites.CommandeEntite;
import entites.CommandesEntite;

public class DaoCommandeImpl implements DaoCommandeInterface{
	private ResultSet resultat = null;
	public DaoCommandeImpl(){
	}
	
	
	public synchronized boolean enregistrerCommande(String message) {
		boolean bool = false;
		
		try {
			String enregistrerCommandeSQL = ConnexionDAO.getProperties().getProperty("enregistrerCommandeSQL");
			PreparedStatement preparedStatement = ConnexionDAO.getInstance().prepareCall(enregistrerCommandeSQL);
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


	
	public synchronized CommandesEntite afficherCommande() {
		CommandesEntite commandesEntite = new CommandesEntite();
		try {
			String afficherCommandeSQL = ConnexionDAO.getProperties().getProperty("afficherCommandeSQL");
			PreparedStatement preparedStatement = ConnexionDAO.getInstance().prepareCall(afficherCommandeSQL);
			resultat = preparedStatement.executeQuery();

			/* Récupération des données du résultat de la requête de lecture */
			while (resultat.next()) {	
				CommandeEntite commandeEntite = new CommandeEntite();
				// On enregistre les données dans l'objet Utilisateur
				commandeEntite.setId(resultat.getInt("id"));
				
				commandeEntite.setMessage(resultat.getString("commandedata"));
				System.out.println(commandeEntite);
				commandesEntite.add(commandeEntite);
				
				
			}
		} catch (SQLException e) {
			e.getMessage();
		} 
	

		return commandesEntite;
	}

}
