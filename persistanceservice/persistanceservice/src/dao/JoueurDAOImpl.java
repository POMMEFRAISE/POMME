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
			/* R�cup�ration des donn�es du r�sultat de la requ�te de lecture */
			while (resultat.next()) {								
				// On enregistre les donn�es dans l'objet Utilisateur
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
				System.out.println("Login et mot de passe trouv�s dans la base de donn�es.");
				bool= true;
				return bool;
			}
			else{
				System.out.println("Les informations saisies n'existent pas dans la base de donn�es !");
				bool= false;
				return bool;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}
}