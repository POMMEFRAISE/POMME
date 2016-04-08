package controller;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import activeMQ.Producteur;
import model.AuthentificationPresentation;
import xml.presentation2metier.Authentification;
import xml.presentation2metier.DemanderAuthentification;
import xml.presentation2metier.ObjectFactory;
import xml.presentation2metier.SeConnecter;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/NavigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ObjectFactory objFactory = new ObjectFactory();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NavigationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	/*
	 * public void init(ServletConfig config) throws ServletException { // TODO
	 * Auto-generated method stub
	 * 
	 * }
	 */

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		
	
		if(request.getSession().getAttribute("utilisateur") == null && request.getParameter("nav")==null) {
				DemanderAuthentification demandeAuthentification = objFactory.createDemanderAuthentification();
				
				new Producteur(demandeAuthentification);

		        request.getRequestDispatcher("/connexion.jsp").forward(request, response);	
		        
		}else if(request.getParameter("nav").equals("creercompte") && request.getSession().getAttribute("utilisateur") == null){
			response.sendRedirect("creercompte.jsp");
		}else {
		switch(request.getParameter("nav")){
			case "rejoindrepartie" :
				this.getServletContext().getRequestDispatcher("/rejoindrepartie.jsp").forward(request, response);
				break;
			case "creerpartie" :
		        this.getServletContext().getRequestDispatcher("/creerpartie.jsp").forward(request, response);  
				break;
			case "jeu" :
				this.getServletContext().getRequestDispatcher("/jeu.jsp").forward(request, response);
				break;
			case "deconnexion" :
				request.getSession().invalidate();
				response.sendRedirect("navigation");
				break;
			case "modifierprofil" :
				this.getServletContext().getRequestDispatcher("/modifierprofil.jsp").forward(request, response);
				break;
			case "consulterscore" :
				this.getServletContext().getRequestDispatcher("/consulterscore.jsp").forward(request, response);
				break;
			case "accueil" :
				this.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
				break;
			case "formcreerpartie" :
				String nom = request.getParameter("nom");
			    String nbjoueur = request.getParameter("nbjoueur");
				if(nom.isEmpty() || nbjoueur.isEmpty()){
		        	request.setAttribute("message", "Les champs doivent être remplis");
		        }
		        this.getServletContext().getRequestDispatcher("/creerpartie.jsp").forward(request, response);  
				break;
			case "formcreercompte" :
				String login = request.getParameter("login");
			    String pwd = request.getParameter("pwd");
			    nom = request.getParameter("nom");
			    String prenom = request.getParameter("prenom");
				if(login.isEmpty() || pwd.isEmpty() || nom.isEmpty() || prenom.isEmpty()){
		        	request.setAttribute("message", "Les champs doivent être remplis");
		        }
		        this.getServletContext().getRequestDispatcher("/creercompte.jsp").forward(request, response);  
				break;
			case "formmodifierprofil" :
				login = request.getParameter("login");
			    pwd = request.getParameter("pwd");
			    nom = request.getParameter("nom");
			    prenom = request.getParameter("prenom");
				if(login.isEmpty() || pwd.isEmpty() || nom.isEmpty() || prenom.isEmpty()){
		        	request.setAttribute("message", "Les champs doivent être remplis");
		        }
		        this.getServletContext().getRequestDispatcher("/modifierprofil.jsp").forward(request, response);  
				break;
			case "formconnexion" :
					login = request.getParameter("login");
				    pwd = request.getParameter("pwd");
				    AuthentificationPresentation auth = new AuthentificationPresentation(login, pwd);
				    Authentification authentification = objFactory.createAuthentification();
				    authentification.setLoginAuthentification(login);
				    authentification.setMdpAuthentification(pwd);
				    
					SeConnecter seConnecter = objFactory.createSeConnecter();
					seConnecter.setAuthentification(authentification);
					
					new Producteur(seConnecter);
					
				    //Joueur joueur = new Joueur(login);
					//HttpSession session = request.getSession();
			        //session.setAttribute("utilisateur", joueur);
			        //request.setAttribute("utilisateur", joueur);
			        
			        //this.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
				break;
		}
        } 
	}
}
