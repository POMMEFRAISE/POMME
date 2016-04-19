package daoimplementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import daointerface.DaoScoreInterface;
import daoparam.ConnexionDAO;
import entites.JoueurEntite;
import entites.PartieEntite;
import entites.ScoreEntite;

public class DaoScoreImpl implements DaoScoreInterface{
	private ResultSet resultat = null;
	private ConnexionDAO connexion;
	public DaoScoreImpl(){
		connexion = new ConnexionDAO();
	}
	@Override
	public String ConsulterScore(JoueurEntite idJoueur, PartieEntite idPartie) {
		ScoreEntite scoreJoueur = new ScoreEntite();
		try {
			String consulterScoreSQL = ConnexionDAO.getProperties().getProperty("consulterScoreSQL");
			PreparedStatement preparedStatement = connexion.getInstance().prepareCall(consulterScoreSQL);
			preparedStatement.setObject(1, idJoueur.getId());
			preparedStatement.setObject(2, idPartie.getId());
			resultat = preparedStatement.executeQuery();
			
			while (resultat.next()) {								
				// On enregistre les données dans l'objet Utilisateur
				scoreJoueur.setResultat(resultat.getString("resultat"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return scoreJoueur.getResultat();
	
	}
}
