package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import activeMQ.Lecteur;

public class JMSListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent arg0) {
		Lecteur lecteur = new Lecteur();
		lecteur.lireMessage();
	}
	
	public void contextDestroyed(ServletContextEvent arg0) {
	
	}
}