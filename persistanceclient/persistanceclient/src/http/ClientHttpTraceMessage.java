package http;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientHttpTraceMessage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3055948564124607625L;
	private String message ;
	private String idMessage;
	private HttpURLConnection connection;
	
	public ClientHttpTraceMessage(String message, String idMessage){
		this.message = message;
		this.idMessage = idMessage;
		connect();
	}
	
	public void connect(){
		try {
			URL url = new URL(recupererValueProperty("URL_TRACE_MESSAGE"));
			System.out.println("Connexion en cours");
			connection = (HttpURLConnection) url.openConnection();
			connection.setDefaultUseCaches(false);
			connection.setDoOutput(true);
			connection.setDoInput(true);	
			
	        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
	        writer.write(idMessage+"\n");
	        writer.write(message);
	        writer.close();
			
			BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			
			while ((line = buffer.readLine()) != null) {
				if (line != null)
				System.out.println(line);
			}        

			buffer.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			connection.disconnect();
			System.out.println("Connexion fermée");
		}
	}
	
    public static String recupererValueProperty(String pro){
		//Permet de charger un fichier properties
    	ResourceBundle prop = ResourceBundle.getBundle("configuration");
		String value = prop.getString(pro);
		return value;
    }
}