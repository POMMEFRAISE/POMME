package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import activeMQ.Lecteur;
import comportement.presentation2metier.DemanderAuthentificationP2MComportement;
import comportement.presentation2metier.SeConnecterP2MComportement;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/NavigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {     
		String login;
		String pwd;
		
		if(request.getSession().getAttribute("utilisateur") == null && request.getParameter("nav")==null) {
			this.getServletContext().getRequestDispatcher("/attente.jsp").forward(request, response);

			DemanderAuthentificationP2MComportement demanderAuthentification = new DemanderAuthentificationP2MComportement();
			demanderAuthentification.envoiMessage();

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
			case "formconnexion" :
				this.getServletContext().getRequestDispatcher("/attente.jsp").forward(request, response);

				login = request.getParameter("login");
				System.out.println("SERVLET : LOGIN "+login);
				pwd = request.getParameter("pwd");
				SeConnecterP2MComportement authentification = new SeConnecterP2MComportement(login, pwd);
				authentification.envoiMessage();

				 //   Joueur joueur = new Joueur(login);
					//HttpSession session = request.getSession();
			        //session.setAttribute("utilisateur", joueur);
			        //request.setAttribute("utilisateur", joueur);

				break;
			case "redirection":
				System.out.println("REQUETE AJAX");
			
				Lecteur lecteur = new Lecteur(true);
				Thread thread = new Thread(lecteur);
				thread.start();
				String redirection = "";

				synchronized(thread){
					while(lecteur.getRedirection() == null){
						try {
							thread.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
					redirection = lecteur.getRedirection();
					System.out.println("Redirection : redirection servlet : "+redirection);
					response.setContentType("text");
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().write(redirection);
					break;
			}
        } 
	}
}