package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

import comportement.Commande;
import util.RecupererValueProperty;

public class AccueilServlet extends HttpServlet
{
	private static final long serialVersionUID = -84682128141930818L;
	
	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		String idMessage;
		String message = "";
	//	Object typeMessage;
        BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()));
     //   ControleMetier controleMetier = new ControleMetier();
        
        idMessage = reader.readLine();
        while(reader.ready()){
        	message = message + reader.readLine();
        }
        reader.close();
        
       // typeMessage = unmarshaller(message);
        
        System.out.println("idMessage :"+idMessage);
        System.out.println("message :"+message);
      //  System.out.println(typeMessage.getClass());
        
        convertirMessageObjet(message);
        
/*        String messageClasse = typeMessage.getClass().getSimpleName();
        Class<?> messageComportement = Class.forName("xml.presentation2metier.comportement."+messageClasse);
        Constructor<Commande>[] constructors = messageComportement.getConstructors();
        Commande commmande = constructors[0].newInstance(typeMessage);
        commande.execute();*/
//        if(typeMessage instanceof DemanderAuthentification){
//        	AuthentificationMetier auth = new AuthentificationMetier(idMessage);
//        	controleMetier.demanderAuthentification(auth);
//        }else if(typeMessage instanceof SeConnecter){
//        	AuthentificationMetier auth = new AuthentificationMetier(
//        			((SeConnecter) typeMessage).getAuthentification().getLoginAuthentification(), 
//        			((SeConnecter) typeMessage).getAuthentification().getMdpAuthentification(), 
//        			idMessage
//        	);
//        	controleMetier.seConnecter(auth);
//        }       
	}
	
	public void convertirMessageObjet(String message){
		Object typeMessage = unmarshaller(message);
        String messageClasse = typeMessage.getClass().getSimpleName();
        Class<?> messageComportement;
		try {
			messageComportement = Class.forName("comportement.presentation2metier."+messageClasse+"Comportement");
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