package activeMQ;
import java.lang.reflect.InvocationTargetException;
import java.util.ResourceBundle;

import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class Lecteur implements Runnable, MessageListener, ExceptionListener{
	public Lecteur(){

	}
	
	public void lireMessage(){
		Connexion connexionMQ = new Connexion("queue/lecteur");

		try {
			String selector = "restrictionSelection = '"+recupererValueProperty("SELECTEUR_MESSAGE_LECTEUR")+"'";

			//Création du consommateur de message
			MessageConsumer consumer = connexionMQ.getSession().createConsumer(connexionMQ.getDestination(), selector);
		
			//Reception du message
			while(true){
				Message messageReçu = consumer.receive();
				this.onMessage(messageReçu);
			}
		} catch (Exception e) {
			System.out.println("Caught exception: " + e);
			e.printStackTrace();
		} finally {
			connexionMQ.closeConnexion();
		}
	}
	
	public void run() {
		lireMessage();
	}

	public void onMessage(Message messageReçu) {
		try {
			if (messageReçu instanceof TextMessage) {
				TextMessage textMessage = (TextMessage) messageReçu;
				System.out.println("Message reçu metier retour: " + textMessage.hashCode()+ " : " + textMessage.getJMSMessageID());
				String messageLu = textMessage.getText();
				
				String maClasse = recupererValueProperty("CLASSE_A_APPELEE");
				Class<?> classeACharger = Class.forName(maClasse);
				classeACharger.getConstructor(String.class, String.class).newInstance(messageLu, textMessage.getJMSMessageID());
			} else {
				System.out.println("Reçu: " + messageReçu);
			}
		} catch (JMSException e) {
			e.printStackTrace();		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

    public synchronized void onException(JMSException ex) {
        System.out.println("JMS Exception occured.  Shutting down client.");
    }
    
    public static String recupererValueProperty(String pro){
		//Permet de charger un fichier properties
    	ResourceBundle prop = ResourceBundle.getBundle("configuration");
		String value = prop.getString(pro);
		return value;
    }
}