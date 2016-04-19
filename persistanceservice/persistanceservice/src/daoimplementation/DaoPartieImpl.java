package daoimplementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import daointerface.DaoPartieInterface;
import daoparam.ConnexionDAO;
import entites.PartieEntite;

public class DaoPartieImpl implements DaoPartieInterface {
	private ResultSet resultat = null;
	public DaoPartieImpl(){
	}
	
	public synchronized boolean creerPartieSQL(PartieEntite partie) {
		PartieEntite partieEntite = new PartieEntite();
		boolean bool = false;

		try {
			String creerPartieSQL = ConnexionDAO.getProperties().getProperty("creerPartieSQL");
			PreparedStatement preparedStatement = ConnexionDAO.getInstance().prepareCall(creerPartieSQL);
			
			preparedStatement.setString(1, partieEntite.getNomPartie());
			preparedStatement.setInt(2, 1);
			preparedStatement.setString(3, "ouvert");
			java.sql.Date  sqlDate = new java.sql.Date(new java.util.Date().getTime());
			preparedStatement.setDate(4, sqlDate);
			
			int resultat = preparedStatement.executeUpdate();
			ConnexionDAO.getInstance().commit();
			
			if (resultat>=1) {
				System.out.print("Partie créee");
				bool= true;
				return bool;
			}else {
				System.out.print("Imposible de créer une partie");
				bool= false;
				return bool;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}

	public synchronized PartieEntite recupererPartie(PartieEntite partie) {
		PartieEntite partieEntite = new PartieEntite();
		
		try {
			String recupererPartieSQL = ConnexionDAO.getProperties().getProperty("recupererPartieSQL");
			PreparedStatement preparedStatement = ConnexionDAO.getInstance().prepareCall(recupererPartieSQL);
			preparedStatement.setString(1, partieEntite.getNomPartie());
			resultat = preparedStatement.executeQuery();
			while (resultat.next()) {								
				partieEntite.setNomPartie(resultat.getString("nomPartie"));
				partieEntite.setStatut(resultat.getString("statut")); 
				partieEntite.setNbredejoueur(resultat.getInt("nbredejoueur"));
				partieEntite.setDatedecreation(resultat.getDate("datedecreation"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return partieEntite;
	}
	
	public synchronized String afficherEtatPartie(String nompartie) {
			PartieEntite partieEntite = new PartieEntite();

		try {
			String afficherEtatPartieSQL = ConnexionDAO.getProperties().getProperty("afficherEtatPartieSQL");
			PreparedStatement preparedStatement = ConnexionDAO.getInstance().prepareCall(afficherEtatPartieSQL);
			
			preparedStatement.setString(1,nompartie );
			resultat = preparedStatement.executeQuery();
			while (resultat.next()) {								
				partieEntite.setNomPartie(resultat.getString("nomPartie"));
				partieEntite.setStatut(resultat.getString("statut")); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "Partie [nomPartie=" + partieEntite.getNomPartie() + ", statut=" + partieEntite.getStatut() + "]";
	}

	
	public synchronized boolean fermerPartieSQL(PartieEntite partie) {
		boolean bool = false;
		PartieEntite partieEntite = new PartieEntite();
		
		try {
			String fermerPartieSQL = ConnexionDAO.getProperties().getProperty("fermerPartieSQL");
			PreparedStatement preparedStatement = ConnexionDAO.getInstance().prepareCall(fermerPartieSQL);
			
			preparedStatement.setString(1, "fermer");
			preparedStatement.setString(2, partieEntite.getNomPartie());
			int resultat = preparedStatement.executeUpdate();
			ConnexionDAO.getInstance().commit();

			if (resultat>=1) {
				System.out.print("Partie fermée");
				bool= true;
				return bool;
			}else {
				System.out.print("Imposible de fermer la partie");
				bool= false;
				return bool;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bool;
	}
		
	


	public synchronized boolean rejoindrePartie(PartieEntite partie) {
		PartieEntite partieEntite = new PartieEntite();
		boolean bool = false;

		try {
			String rejoindrePartieSQL = ConnexionDAO.getProperties().getProperty("rejoindrePartieSQL");
			PreparedStatement preparedStatement = ConnexionDAO.getInstance().prepareCall(rejoindrePartieSQL);
			
			preparedStatement.setString(1, partieEntite.getNomPartie());
			preparedStatement.setInt(2, partieEntite.getNbredejoueur()+1);
			preparedStatement.setString(3, partieEntite.getStatut());
			java.sql.Date  sqlDate = new java.sql.Date(new java.util.Date().getTime());
			preparedStatement.setDate(4, sqlDate);
			
			int resultat = preparedStatement.executeUpdate();
			ConnexionDAO.getInstance().commit();
			
			if (resultat>=1) {
				System.out.print("Joueur Enregistré");
				bool= true;
				return bool;
			}else {
				System.out.print("Imposible d'enregistrer le joueur");
				bool= false;
				return bool;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}

}
