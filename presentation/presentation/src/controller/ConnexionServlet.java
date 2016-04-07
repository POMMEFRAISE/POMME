package controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import activeMQ.Producteur;
import model.AuthentificationPresentation;
import model.Joueur;
import xml.presentation2metier.Authentification;
import xml.presentation2metier.DemanderAuthentification;
import xml.presentation2metier.ObjectFactory;
import xml.presentation2metier.SeConnecter;

/**
 * Servlet implementation class Connexion
 */
//@WebServlet("/Connexion")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ObjectFactory objFactory = new ObjectFactory();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DemanderAuthentification demandeAuthentification = objFactory.createDemanderAuthentification();
		
		URL url = null;
		try {
			url = new URL(getClass().getProtectionDomain().getCodeSource().getLocation(),"configuration.properties");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		new Producteur(demandeAuthentification, url);

        request.getRequestDispatcher("/connexion.jsp").forward(request, response);	
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	    
	    //Récupération des paramètres de la requête
	    String login = request.getParameter("login");
	    String pwd = request.getParameter("pwd");
	    AuthentificationPresentation auth = new AuthentificationPresentation(login, pwd);
	    Authentification authentification = objFactory.createAuthentification();
	    authentification.setLoginAuthentification(login);
	    authentification.setMdpAuthentification(pwd);
	    
		SeConnecter seConnecter = objFactory.createSeConnecter();
		seConnecter.setAuthentification(authentification);
		
		URL url = null;
		try {
			url = new URL(getClass().getProtectionDomain().getCodeSource().getLocation(),"configuration.properties");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		new Producteur(seConnecter, url);
		
	    Joueur joueur = new Joueur(login);
		HttpSession session = request.getSession();
        session.setAttribute("utilisateur", joueur);
        request.setAttribute("utilisateur", joueur);
        
        /*String message;
        
        if(login.trim().isEmpty() || pwd.trim().isEmpty()){
        	message="Les champs doivent être remplis";
        	request.setAttribute("message", message);
        	this.getServletContext().getRequestDispatcher("connexion").forward(request, response);
        }else {
        	message="Connexion réussie";
        	request.setAttribute("message", message);
        	this.getServletContext().getRequestDispatcher("accueil").forward(request, response);
        }*/
                
        response.sendRedirect("navigation");          
	}
	
}