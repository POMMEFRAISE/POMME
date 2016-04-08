package controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import activeMQ.Lecteur;

public class JMSContextListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent arg0) {
		Thread thread = new Thread(new Lecteur());
		thread.start();
	}
	
	public void contextDestroyed(ServletContextEvent arg0) {
	
	}
}