package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entites.JoueurEntite;

public class JoueurDAOImpl implements JoueurDAOInterface{
	private ResultSet resultat = null;
	
	public JoueurDAOImpl(){
		
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
			}
		} catch (SQLException e) {
			e.getMessage();
		} 
		return joueurEntite;
	}
	
	public synchronized boolean verificationJoueur(String login, String motdepasse) {
		boolean bool = false;
		System.out.println("Login : "+login);
		System.out.println("MDP :" + motdepasse);
		try {
			String verificationSQL = ConnexionDAO.getProperties().getProperty("verificationJoueurSQL");
			PreparedStatement preparedStatement = ConnexionDAO.getInstance().prepareCall(verificationSQL);
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, motdepasse);
			resultat = preparedStatement.executeQuery();
			
			if (resultat.next()){
				System.out.println("Login et mot de passe trouvés dans la base de données.");
				bool= true;
				return bool;
			}
			else{
				System.out.println("Les informations saisies n'existent pas dans la base de données !");
				bool= false;
				return bool;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}
}