package activeMQ;
import java.io.StringWriter;
import java.util.ResourceBundle;

import javax.jms.DeliveryMode;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

public class Producteur{
	private Object objetAEnvoyer;

	public Producteur(Object objetAEnvoyer){
		this.objetAEnvoyer = objetAEnvoyer;
		produireMessage();
	}
	
	public void produireMessage(){
		Connexion connexionMQ = new Connexion("queue/producteur");
		try {

			//Création du producteur de message
			MessageProducer producer = connexionMQ.getSession().createProducer(connexionMQ.getDestination());
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			
			//Création du message 
			TextMessage messageEnvoye = connexionMQ.getSession().createTextMessage(marshaller(objetAEnvoyer));			
			messageEnvoye.setStringProperty("restrictionSelection", recupererValueProperty("SELECTEUR_MESSAGE_PRODUCTEUR"));

			//Envoie du message
			producer.send(messageEnvoye);
			System.out.println("Message envoyé : " + messageEnvoye.hashCode()+ " : " + messageEnvoye.getJMSMessageID());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connexionMQ.closeConnexion();
		}
	}
	
	public String marshaller(Object objetAEnvoyer){
		Marshaller marshaller;
		JAXBContext context;
		StringWriter writer;
		String messageAEnvoyer = null;
		
		try {
			context = JAXBContext.newInstance(recupererValueProperty("XML_PRODUCTEUR"));
			marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			writer = new StringWriter();
			marshaller.marshal(objetAEnvoyer, writer);
			messageAEnvoyer = writer.toString();
		} catch (PropertyException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return messageAEnvoyer;
	}
	
    public static String recupererValueProperty(String pro){
    	ResourceBundle prop = ResourceBundle.getBundle("configuration");
		String value = prop.getString(pro);
		return value;
    }
}