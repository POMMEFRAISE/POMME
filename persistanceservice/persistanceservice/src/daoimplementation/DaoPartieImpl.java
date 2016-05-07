package daoimplementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import daointerface.DaoPartieInterface;
import daoparam.ConnexionDAO;
import entites.JoueurEntite;
import entites.PartieEntite;
import entites.PartiesEntite;

public class DaoPartieImpl implements DaoPartieInterface {
	private ResultSet resultat = null;
	public DaoPartieImpl(){
	}
	
	public synchronized boolean creerPartie(PartieEntite partie) {
		boolean bool = false;

		try {
			if (verifierPartie (partie.getNomPartie()) == false){
				String creerPartieSQL = ConnexionDAO.getProperties().getProperty("creerPartieSQL");
				PreparedStatement preparedStatement = ConnexionDAO.getInstance().prepareCall(creerPartieSQL);
				
				preparedStatement.setString(1, partie.getNomPartie());
				preparedStatement.setInt(2, partie.getNbredejoueur());
				preparedStatement.setString(3, "ouvert");
				
				int resultat = preparedStatement.executeUpdate();
				
				if (resultat>=1) {
					System.out.print("Partie créee");
					bool= true;
					return bool;
				}else {
					System.out.print("Imposible de créer une partie");
					bool= false;
					return bool;
				}
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}

	public synchronized PartieEntite recupererPartie(PartieEntite partie) {
		PartieEntite partieEntite = new PartieEntite();
		
		try {
			if (verifierPartie (partie.getNomPartie()) == true){
				String recupererPartieSQL = ConnexionDAO.getProperties().getProperty("recupererPartieSQL");
				PreparedStatement preparedStatement = ConnexionDAO.getInstance().prepareCall(recupererPartieSQL);
				preparedStatement.setString(1, partie.getNomPartie());
				resultat = preparedStatement.executeQuery();
				
				while (resultat.next()) {								
					partieEntite.setNomPartie(resultat.getString("nomPartie"));
					partieEntite.setStatut(resultat.getString("statut")); 
					partieEntite.setNbredejoueur(resultat.getInt("nbredejoueur"));
					partieEntite.setDatedecreation(resultat.getDate("datecreation"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return partieEntite;
	}

	public synchronized PartiesEntite recupererListeParties() {
		PartiesEntite partiesEntite = new PartiesEntite();
		
		try {
			String recupererPartieSQL = ConnexionDAO.getProperties().getProperty("recupererListePartieSQL");
			PreparedStatement preparedStatement = ConnexionDAO.getInstance().prepareCall(recupererPartieSQL);
			resultat = preparedStatement.executeQuery();
				
			while (resultat.next()) {	
				PartieEntite partieEntite = new PartieEntite();
				partieEntite.setNomPartie(resultat.getString("nomPartie"));
				partieEntite.setStatut(resultat.getString("statut")); 
				partieEntite.setNbredejoueur(resultat.getInt("nbredejoueur"));
				partieEntite.setDatedecreation(resultat.getDate("datecreation"));
				partiesEntite.add(partieEntite);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return partiesEntite;
	}
	
	public synchronized String afficherEtatPartie(String nompartie) {
			PartieEntite partieEntite = new PartieEntite();

		try {
			if (verifierPartie (nompartie) == true){
				String afficherEtatPartieSQL = ConnexionDAO.getProperties().getProperty("afficherEtatPartieSQL");
				PreparedStatement preparedStatement = ConnexionDAO.getInstance().prepareCall(afficherEtatPartieSQL);
				
				preparedStatement.setString(1,nompartie );
				resultat = preparedStatement.executeQuery();
				while (resultat.next()) {								
					partieEntite.setNomPartie(resultat.getString("nomPartie"));
					partieEntite.setStatut(resultat.getString("statut")); 
					
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "Partie [nomPartie=" + partieEntite.getNomPartie() + ", statut=" + partieEntite.getStatut() + "]";
	}

	
	public synchronized boolean fermerPartie(PartieEntite partie) {
		boolean bool = false;
		
		try {
			if (verifierPartie(partie.getNomPartie()) == true){
				String fermerPartieSQL = ConnexionDAO.getProperties().getProperty("fermerPartieSQL");
				PreparedStatement preparedStatement = ConnexionDAO.getInstance().prepareCall(fermerPartieSQL);
				
				preparedStatement.setString(1, "fermer");
				preparedStatement.setString(2, partie.getNomPartie());
				int resultat = preparedStatement.executeUpdate();

				if (resultat>=1) {
					System.out.print("Partie fermée");
					bool= true;
					return bool;
				}else {
					System.out.print("Imposible de fermer la partie");
					bool= false;
					return bool;
				}
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bool;
	}
		
	


	public synchronized boolean rejoindrePartie(PartieEntite partie, JoueurEntite joueur, Integer numeroPresentation) {
		boolean bool = false;

		try {
			String rejoindrePartieSQL = ConnexionDAO.getProperties().getProperty("rejoindrePartieSQL");
			PreparedStatement preparedStatement = ConnexionDAO.getInstance().prepareCall(rejoindrePartieSQL);
				
			preparedStatement.setString(1, joueur.getLogin());
			preparedStatement.setString(2, partie.getNomPartie());
			preparedStatement.setInt(3, numeroPresentation);
				
			int resultat = preparedStatement.executeUpdate();
				
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

	@Override
	public synchronized boolean verifierPartie(String nompartie) {
		boolean bool = false;
		try {
			String verifierPartieSQL = ConnexionDAO.getProperties().getProperty("verifierPartieSQL");
			PreparedStatement preparedStatement = ConnexionDAO.getInstance().prepareCall(verifierPartieSQL);
			preparedStatement.setString(1, nompartie);
			resultat = preparedStatement.executeQuery();
			
			if (resultat.next()){
				System.out.println("La Partie existe bien.");
				bool= true;
				return bool;
			}
			else{
				System.out.println("La Partie n'existe pas ");
				bool= false;
				return bool;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}

	public synchronized boolean verifierPartieRejoindre(String nompartie) {
		boolean bool = false;
		try {
			String verifierPartieRejoindreSQL = ConnexionDAO.getProperties().getProperty("verifierPartieRejoindreSQL");
			PreparedStatement preparedStatement = ConnexionDAO.getInstance().prepareCall(verifierPartieRejoindreSQL);
			preparedStatement.setString(1, nompartie);
			preparedStatement.setString(1, nompartie);
			resultat = preparedStatement.executeQuery();
			
			if (resultat.next()){
				System.out.println("La Partie existe bien.");
				bool= true;
				return bool;
			}
			else{
				System.out.println("La Partie n'existe pas ");
				bool= false;
				return bool;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}
}
