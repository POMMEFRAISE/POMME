package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class RecupererRequete {
	private static Connection connection = null;
	private static ConnexionDAO connexiondao;
	private static Properties properties;
	
	public static void recupererRequete(){
		connexiondao = ConnexionDAO.getInstance();
		properties = new Properties();
		InputStream inStream = RecupererRequete.class.getResourceAsStream("requetes.properties");

		try {
			properties.load(inStream);
			connexiondao.getConnection();
//			setConnection(connexiondao.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Properties getProperties() {
		return properties;
	}

	public static void setProperties(Properties properties) {
		RecupererRequete.properties = properties;
	}

	public static Connection getConnection() {
		return connection;
	}

	public static void setConnection(Connection connection) {
		RecupererRequete.connection = connection;
	}
}