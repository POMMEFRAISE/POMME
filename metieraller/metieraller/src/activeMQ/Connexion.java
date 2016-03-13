package activeMQ;
import java.util.ResourceBundle;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;

public class Connexion{
	private Session session;
	private Connection connection;
	private Context context;
	private Destination destination;
	private InitialContext initialContext;
	
	public Connexion(String queueUtiliser){
	    try{
	        initialContext = new InitialContext();
	        context = (Context) initialContext.lookup(recupererValueProperty("INITIAL_CONTEXT"));

	        //Création d'une connexion factory
	    	ConnectionFactory connectionFactory = (ConnectionFactory)context.lookup("connectionFactory");

	    	//Création d'une connexion
	    	connection = connectionFactory.createConnection();
	    	connection.start();

	    	//Création d'une session
	    	session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	    	
	    	//Création d'une destination
	    	destination = (Destination) context.lookup(queueUtiliser);
	    }catch (Exception e) {
			System.out.println("Caught Exception: " + e);
			e.printStackTrace();
		}
	}
	
	public void closeConnexion(){
		try {
			session.close();
			connection.close();
		} catch (Exception e) {
			System.out.println("Caught Exception: " + e);
			e.printStackTrace();
		}
	}
	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	
    public static String recupererValueProperty(String pro){
		//Permet de charger un fichier properties
    	ResourceBundle prop = ResourceBundle.getBundle("configuration");
		String value = prop.getString(pro);
		return value;
    }
}