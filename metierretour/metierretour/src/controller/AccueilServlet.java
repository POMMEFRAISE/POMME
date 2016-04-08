package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

import model.ActionMetier;
import model.AuthentificationMetier;
import model.JoueurMetier;
import util.RecupererValueProperty;
import xml.integration2metier.ReponseDemanderAuthentification;
import xml.integration2metier.ReponseSeConnecter;

public class AccueilServlet extends HttpServlet
{
	private static final long serialVersionUID = -84682128141930818L;

	public void init(ServletConfig config) throws ServletException {

	}
	
	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		String idMessage;
		String message = "";
		Object typeMessage;
        BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()));
        ActionMetier actionMetier = new ActionMetier();

        idMessage = reader.readLine();
        while(reader.ready()){
        	message = message + reader.readLine();
        }
        reader.close();
        
        typeMessage = unmarshaller(message);
        
        System.out.println("idMessage :"+idMessage);
        System.out.println("message :"+message);
        System.out.println(typeMessage.getClass());
        
        if(typeMessage instanceof ReponseDemanderAuthentification){
        	AuthentificationMetier auth = new AuthentificationMetier(idMessage);
        	actionMetier.demanderAuthentification(auth);
        }else if(typeMessage instanceof ReponseSeConnecter){
        	JoueurMetier joueur = new JoueurMetier(
        			((ReponseSeConnecter) typeMessage).getAuthentification().getJoueur().getNomJoueur(),
        			((ReponseSeConnecter) typeMessage).getAuthentification().getJoueur().getPrenomJoueur(),
        			((ReponseSeConnecter) typeMessage).getAuthentification().getJoueur().getLoginJoueur()
        	);
        			
        	AuthentificationMetier auth = new AuthentificationMetier(
        			joueur, 
        			idMessage, 
        			((ReponseSeConnecter) typeMessage).getAuthentification().getMessageErreur()
        	);
        	actionMetier.seConnecter(auth);
        }
	}
	
	public Object unmarshaller(String message){
		Object object = null;
		Unmarshaller unmarshaller;
		JAXBContext context;
		StringReader reader;
		
		try {
			context = JAXBContext.newInstance(RecupererValueProperty.recupererValueProperty("XML_LECTEUR"));
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
}