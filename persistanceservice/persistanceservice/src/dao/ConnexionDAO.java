package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnexionDAO {
	
	private static Properties properties;
	private static String url;
	private static String utilisateur;
	private static String motDePasse;
	@SuppressWarnings("static-access")
	ConnexionDAO (String url, String utilisateur, String motDePasse ){
		this.url= url;
		this.utilisateur=utilisateur;
		this.motDePasse=motDePasse;
	}

	
	public static ConnexionDAO getInstance(){
		properties = new Properties();
		InputStream inStream = ConnexionDAO.class.getResourceAsStream("requetes.properties");
		try {
			properties.load(inStream);
			String driverName = properties.getProperty("driver");
			Class.forName(driverName);
			System.out.println("# Le driver est correctement chargé : " );
		} catch (Exception e) {
			System.err.println("# Mauvais nom du driver MySQL.");
			e.printStackTrace();
		}

		url = properties.getProperty("url");
		utilisateur = properties.getProperty("utilisateur");
		motDePasse = properties.getProperty("motDePasse");
        
		ConnexionDAO instance = new ConnexionDAO(url,utilisateur,motDePasse);
		return instance;
	}
	
	Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, utilisateur, motDePasse);
	}
}
