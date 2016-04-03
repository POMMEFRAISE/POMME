package controller;

import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import activeMQ.Lecteur;

public class JMSContextListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent arg0) {
		URL url = null;
		try {
			url = new URL(getClass().getProtectionDomain().getCodeSource().getLocation(),"configuration.properties");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		Thread thread = new Thread(new Lecteur(url));
		thread.start();
	}
	
	public void contextDestroyed(ServletContextEvent arg0) {
	
	}
}