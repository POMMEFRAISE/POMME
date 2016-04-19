package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import activeMQ.Lecteur;

public class JMSListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent context) {
		Thread thread = new Thread(new Lecteur());
		thread.start();
	}
	
	public void contextDestroyed(ServletContextEvent arg0) {
	
	}
}