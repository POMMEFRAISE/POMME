package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import activeMQ.Lecteur;
import comportement.presentation2metier.DemanderAuthentificationP2MComportement;
import comportement.presentation2metier.SeConnecterP2MComportement;
import model.ActionPresentation;
import model.Joueur;
import model.MessageErreur;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/NavigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ActionPresentation actionPresentation ;
	private String message;
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {     
		actionPresentation = new ActionPresentation();
		HttpSession session = request.getSession();
		String login;
		String pwd;
		
		if(session.getAttribute("joueur") == null && request.getParameter("nav")==null){
			DemanderAuthentificationP2MComportement demanderAuthentification = new DemanderAuthentificationP2MComportement();
			demanderAuthentification.envoiMessage();
			appelLecteur();
			System.out.println("MEssage servlet : "+message);

			MessageErreur messageErreur = (MessageErreur) actionPresentation.getObjetARetourner();
			System.out.println("message Erreur servlet: " + messageErreur.isStatut());
			if(messageErreur.isStatut() == true){
				this.getServletContext().getRequestDispatcher("/connexion.jsp").forward(request, response);
			}else{
				this.getServletContext().getRequestDispatcher("/erreur.jsp").forward(request, response);
			}
		}else if(session.getAttribute("joueur") != null && request.getParameter("nav")==null) {
			this.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
		}else if(request.getParameter("nav").equals("creercompte") && session.getAttribute("joueur") == null){
			response.sendRedirect("creercompte.jsp");
		}else if(session.getAttribute("joueur") == null && request.getParameter("nav") == "formconnexion"){
			//this.getServletContext().getRequestDispatcher("/attente.jsp").forward(request, response);

			login = request.getParameter("login");
			pwd = request.getParameter("pwd");
			SeConnecterP2MComportement authentification = new SeConnecterP2MComportement(login, pwd);
			authentification.envoiMessage();

			appelLecteur();
			System.out.println("MEssage servlet : "+message);

			Joueur joueur = (Joueur) actionPresentation.getObjetARetourner();
			System.out.println("joueur : " + joueur.isStatut());
			System.out.println("joueur : " + joueur.getLogin());

			if(joueur.isStatut() == true){
			    session.setAttribute("joueur", joueur);
			    request.setAttribute("joueur", joueur);
				this.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
			}else{
				this.getServletContext().getRequestDispatcher("/connexion.jsp").forward(request, response);
			}
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
				login = request.getParameter("login");
			    pwd = request.getParameter("pwd");
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
			}
        } 
	}
	
	public void appelLecteur(){
		Lecteur lecteur = new Lecteur();
		Thread thread = new Thread(lecteur);
		thread.start();

		synchronized(thread){
			while(lecteur.getMessage() == null){
				try {
					thread.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		message = lecteur.getMessage();
		thread.interrupt();
		actionPresentation.setMessage(message);
		actionPresentation.convertirMessageObjet();
	}
}