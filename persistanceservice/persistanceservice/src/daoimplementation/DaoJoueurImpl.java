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
	
	public synchronized boolean verifierJoueur(String login, String motdepasse) {
		boolean bool = false;
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

	
	public synchronized boolean creerCompte(JoueurEntite joueur) {
		JoueurEntite joueurEntite = new JoueurEntite();
		boolean bool = false;
		try {
			String creerCompteSQL = ConnexionDAO.getProperties().getProperty("creerCompteSQL");
			PreparedStatement preparedStatement = ConnexionDAO.getInstance().prepareCall(creerCompteSQL);
			
			preparedStatement.setString(1, joueurEntite.getNom());
			preparedStatement.setString(2, joueurEntite.getPrenom());
			preparedStatement.setString(3, joueurEntite.getEmail());
			preparedStatement.setString(4, joueurEntite.getLogin());
			preparedStatement.setString(5, joueurEntite.getMotDePasse());
			
			int resultat = preparedStatement.executeUpdate();
			ConnexionDAO.getInstance().commit();

			
			if (resultat>=1) {
				System.out.print("Joueur Cr�ee");
				bool= true;
				return bool;
			}else {
				System.out.print("Imposible de cr�er un joueur");
				bool= false;
				return bool;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
			ConnexionDAO.getInstance().commit();

			if (resultat>=1) {
				System.out.print("Profil Modifi�");
				bool= true;
				return bool;
			}else {
				System.out.print("Imposible de modifier le profil du joueur");
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