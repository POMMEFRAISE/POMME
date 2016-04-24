package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comportement.Commande;
import util.JAXB;

public class AccueilServlet extends HttpServlet
{
	private static final long serialVersionUID = -84682128141930818L;

	public void init(ServletConfig config) throws ServletException {

	}
	
	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		String idMessage;
		String message = "";
      
		BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()));

        idMessage = reader.readLine();
        while(reader.ready()){
        	message = message + reader.readLine();
        }
        reader.close();

        System.out.println("idMessage :"+idMessage);
        System.out.println("message :"+message);
       
        convertirMessageObjet(message);
	}
	
	public void convertirMessageObjet(String message){
		Object typeMessage = JAXB.unmarshaller(message);
        String messageClasse = typeMessage.getClass().getSimpleName();
        Class<?> messageComportement;
		try {
			messageComportement = Class.forName("comportement.integration2metier."+messageClasse+"Comportement");
	        Constructor<?>[] constructors = messageComportement.getConstructors();
	        Commande commande = (Commande) constructors[0].newInstance(typeMessage);
	        commande.reçoiMessage();
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
		}
	}
}