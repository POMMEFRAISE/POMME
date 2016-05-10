package daoimplementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import daointerface.DaoJoueurInterface;
import daoparam.ConnexionDAO;
import entites.JoueurEntite;

public class DaoJoueurImpl implements DaoJoueurInterface{
	private ResultSet resultat = null;
	public DaoJoueurImpl(){
	}
	
	public synchronized JoueurEntite recupererJoueur(JoueurEntite joueur) {
		JoueurEntite joueurEntite = new JoueurEntite();
		try {
			String recupererJoueurSQL = ConnexionDAO.getProperties().getProperty("recupererJoueurSQL");
			PreparedStatement preparedStatement = ConnexionDAO.getInstance().prepareCall(recupererJoueurSQL);
			preparedStatement.setString(1, joueur.getLogin());
			preparedStatement.setString(2, joueur.getMotDePasse());
			resultat = preparedStatement.executeQuery();
			/* Récupération des données du résultat de la requête de lecture */
			while (resultat.next()) {								
				// On enregistre les données dans l'objet Utilisateur
				joueurEntite.setLogin(resultat.getString("login"));
				joueurEntite.setNom(resultat.getString("nom"));
				joueurEntite.setPrenom(resultat.getString("prenom"));
				joueurEntite.setEmail(resultat.getString("email"));
				joueurEntite.setId(resultat.getInt("id"));

			}
		} catch (SQLException e) {
			e.getMessage();
		} 
		return joueurEntite;
	}
	
	public synchronized boolean verifierJoueur(String login, String motdepasse) {
		boolean bool = false;
		try {
			String verifierJoueurSQL = ConnexionDAO.getProperties().getProperty("verifierJoueurSQL");
			PreparedStatement preparedStatement = ConnexionDAO.getInstance().prepareCall(verifierJoueurSQL);
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, motdepasse);
			resultat = preparedStatement.executeQuery();
			
			if (resultat.next()){
				bool= true;
				return bool;
			}
			else{
				bool= false;
				return bool;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}

	
	public synchronized boolean creerCompte(JoueurEntite joueur) {
		boolean bool = false;
		try {
			if (verifierJoueur (joueur.getLogin(),joueur.getMotDePasse()) == false){
				String creerCompteSQL = ConnexionDAO.getProperties().getProperty("creerCompteSQL");
				PreparedStatement preparedStatement = ConnexionDAO.getInstance().prepareCall(creerCompteSQL);
				
				preparedStatement.setString(1, joueur.getNom());
				preparedStatement.setString(2, joueur.getPrenom());
				preparedStatement.setString(3, joueur.getEmail());
				preparedStatement.setString(4, joueur.getLogin());
				preparedStatement.setString(5, joueur.getMotDePasse());
				
				int resultat = preparedStatement.executeUpdate();

				
				if (resultat>=1) {
					bool= true;
					return bool;
				}else {
					bool= false;
					return bool;
				}
			
		} 
		}	catch (SQLException e) {
			e.printStackTrace();
			}
		return bool;
	}

	public synchronized boolean gererProfil(JoueurEntite joueur) {
		boolean bool = false;
		JoueurEntite joueurEntite = new JoueurEntite();
		
		try {
			String gererProfilJoueurSQL = ConnexionDAO.getProperties().getProperty("gererProfilJoueurSQL");
			PreparedStatement preparedStatement = ConnexionDAO.getInstance().prepareCall(gererProfilJoueurSQL);
			
			preparedStatement.setString(1, joueurEntite.getNom());
			preparedStatement.setString(2, joueurEntite.getPrenom());
			preparedStatement.setString(3, joueurEntite.getEmail());
			preparedStatement.setString(4, joueurEntite.getLogin());
			preparedStatement.setString(5, joueurEntite.getMotDePasse());
			preparedStatement.setInt(6, joueurEntite.getId());
			
			int resultat = preparedStatement.executeUpdate();

			if (resultat>=1) {
				bool= true;
				return bool;
			}else {
				bool= false;
				return bool;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bool;
	}
}