package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

import model.AuthentificationMetier;
import model.ControleMetier;
import xml.presentation2metier.DemanderAuthentification;
import xml.presentation2metier.SeConnecter;

public class AccueilServlet extends HttpServlet
{
	private static final long serialVersionUID = -84682128141930818L;
	
	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		String idMessage;
		String message = "";
		Object typeMessage;
        BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()));
        ControleMetier controleMetier = new ControleMetier();
        
        idMessage = reader.readLine();
        while(reader.ready()){
        	message = message + reader.readLine();
        }
        reader.close();
        
        typeMessage = unmarshaller(message);
        
        System.out.println("idMessage :"+idMessage);
        System.out.println("message :"+message);
        System.out.println(typeMessage.getClass());
        
        if(typeMessage instanceof DemanderAuthentification){
        	AuthentificationMetier auth = new AuthentificationMetier(idMessage);
        	controleMetier.demanderAuthentification(auth);
        }else if(typeMessage instanceof SeConnecter){
        	AuthentificationMetier auth = new AuthentificationMetier(
        			((SeConnecter) typeMessage).getAuthentification().getLoginAuthentification(), 
        			((SeConnecter) typeMessage).getAuthentification().getMdpAuthentification(), 
        			idMessage
        	);
        	controleMetier.seConnecter(auth);
        }       
	}
	
	public Object unmarshaller(String message){
		Object object = null;
		Unmarshaller unmarshaller;
		JAXBContext context;
		StringReader reader;
		
		try {
			context = JAXBContext.newInstance(recupererValueProperty("XML_LECTEUR"));
			unmarshaller = context.createUnmarshaller();
			reader = new StringReader(message);
			object = unmarshaller.unmarshal(reader);
		} catch (PropertyException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return object;
	}
	
    public static String recupererValueProperty(String pro){
		//Permet de charger un fichier properties
    	ResourceBundle prop = ResourceBundle.getBundle("configuration");
		String value = prop.getString(pro);
		return value;
    }
}