package daoparam;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnexionDAO {
	
	private static Properties properties;

	public static Properties getProperties(){
		properties = new Properties();
		InputStream inStream = ConnexionDAO.class.getResourceAsStream("requetes.properties"); 
		try {
			properties.load(inStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
	
	public static Connection getInstance(){
		Connection connection = null;
		getProperties();
		try {
			String driverName = properties.getProperty("driver");
			Class.forName(driverName);
		} catch (Exception e) {
			System.err.println("# Mauvais nom du driver MySQL.");
			e.printStackTrace();
		}

		String url = properties.getProperty("url");
		String utilisateur = properties.getProperty("utilisateur");
		String motDePasse = properties.getProperty("motDePasse");
        
		try {
			connection = DriverManager.getConnection(url, utilisateur, motDePasse);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}