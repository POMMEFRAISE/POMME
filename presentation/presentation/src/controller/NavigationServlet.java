package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import activeMQ.Lecteur;
import comportement.presentation2metier.CreerPartieP2MComportement;
import comportement.presentation2metier.DemanderAuthentificationP2MComportement;
import comportement.presentation2metier.DemanderCreerPartieP2MComportement;
import comportement.presentation2metier.DemanderNumeroPresentationP2MComportement;
import comportement.presentation2metier.SeConnecterP2MComportement;
import model.ActionPresentation;
import model.Joueur;
import model.MessageErreur;
import model.Partie;

/**
 * Servlet implementation class NavigationServlet
 */
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ActionPresentation actionPresentation ;
	private String message;
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {     
		actionPresentation = new ActionPresentation();
		HttpSession session = request.getSession();
		int numero = 0;
		
		String url = request.getParameter("nav");
		if(url == null){
			url = "";
		}
		
		Integer numeroPresentation = (Integer) session.getAttribute("numeroPresentation");
		if(numeroPresentation == null){
			DemanderNumeroPresentationP2MComportement demanderNumeroPresentation = new DemanderNumeroPresentationP2MComportement();
			demanderNumeroPresentation.envoiMessage();
			appelLecteur(numero);
			numero = (Integer) actionPresentation.getObjetARetourner();
		    session.setAttribute("numeroPresentation", numero);
		}else{
			numero = numeroPresentation;			
		}
		
		if(session.getAttribute("joueur") == null && url.equals("")){
			DemanderAuthentificationP2MComportement demanderAuthentification = new DemanderAuthentificationP2MComportement(numero);
			demanderAuthentification.envoiMessage();
			appelLecteur(numero);

			MessageErreur messageErreur = (MessageErreur) actionPresentation.getObjetARetourner();
			System.out.println("message Erreur servlet: " + messageErreur.isStatut());
			if(messageErreur.isStatut() == true){
				this.getServletContext().getRequestDispatcher("/connexion.jsp").forward(request, response);
			}else{
				this.getServletContext().getRequestDispatcher("/erreur.jsp").forward(request, response);
			}
		}else if(url.equals("creercompte") && session.getAttribute("joueur") == null){
			response.sendRedirect("creercompte.jsp");
		}else {
		switch(url){
			case "":
				this.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
				break;
			case "rejoindrepartie" :
				this.getServletContext().getRequestDispatcher("/rejoindrepartie.jsp").forward(request, response);
				break;
			case "creerpartie" :
				if (session.getAttribute("joueur") == null){
					response.sendRedirect("navigation?nav=");
				}else{
					DemanderCreerPartieP2MComportement demanderCreerPartie = new DemanderCreerPartieP2MComportement(numero);
					demanderCreerPartie.envoiMessage();
					appelLecteur(numero);

					MessageErreur messageErreur = (MessageErreur) actionPresentation.getObjetARetourner();
					if(messageErreur.isStatut() == true){
						this.getServletContext().getRequestDispatcher("/creerpartie.jsp").forward(request, response);
					}else{
						this.getServletContext().getRequestDispatcher("/erreur.jsp").forward(request, response);
					}
				}
				break;
			case "jeu" :
				this.getServletContext().getRequestDispatcher("/jeu.jsp").forward(request, response);
				break;
			case "deconnexion" :
				request.getSession().invalidate();
				response.sendRedirect("navigation?nav=");
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
				if (session.getAttribute("joueur") == null){
					response.sendRedirect("navigation?nav=");
				}else{
					String nomPartie = request.getParameter("nom");
					String nbJoueurPartie = request.getParameter("nbjoueur");
					int nbJoueur = Integer.parseInt(nbJoueurPartie);
					System.out.println("nb Joueur : "+nbJoueur);
					CreerPartieP2MComportement creerPartie = new CreerPartieP2MComportement(nomPartie, nbJoueur, numero);
					creerPartie.envoiMessage();
	
					appelLecteur(numero);
	
					Partie partie = (Partie) actionPresentation.getObjetARetourner();
					if(partie.isStatut() == true){
						response.sendRedirect("navigation?nav=rejoindrepartie");
					}else{
						request.setAttribute("partie", partie);
						this.getServletContext().getRequestDispatcher("/creerpartie.jsp").forward(request, response);
					}
				}
				break;
			case "formcreercompte" :
				String loginCreerCompte = request.getParameter("login");
			    String mdpCreerCompte = request.getParameter("pwd");
			    String nomCreerCompte = request.getParameter("nom");
			    String prenomCreerCompte = request.getParameter("prenom");
				if(loginCreerCompte.isEmpty() || mdpCreerCompte.isEmpty() || nomCreerCompte.isEmpty() || prenomCreerCompte.isEmpty()){
		        	request.setAttribute("message", "Les champs doivent �tre remplis");
		        }
		        this.getServletContext().getRequestDispatcher("/creercompte.jsp").forward(request, response);  
				break;
			case "formmodifierprofil" :
				String loginModifProfil = request.getParameter("login");
			    String mdpModifProfil = request.getParameter("pwd");
			    String nomModifProfil = request.getParameter("nom");
			    String prenomModifProfil = request.getParameter("prenom");
				if(loginModifProfil.isEmpty() || mdpModifProfil.isEmpty() || nomModifProfil.isEmpty() || prenomModifProfil.isEmpty()){
		        	request.setAttribute("message", "Les champs doivent �tre remplis");
		        }
		        this.getServletContext().getRequestDispatcher("/modifierprofil.jsp").forward(request, response);  
				break;
			case "formconnexion" :
				if(session.getAttribute("joueur") != null){
					response.sendRedirect("navigation?nav=accueil");
				}else if (session.getAttribute("joueur") == null && request.getParameter("login") == null){
					response.sendRedirect("navigation?nav=");
				}else{
					String loginConnexion = request.getParameter("login");
					String mdpConnexion = request.getParameter("pwd");
					SeConnecterP2MComportement authentification = new SeConnecterP2MComportement(loginConnexion, mdpConnexion, numero);
					authentification.envoiMessage();
	
					appelLecteur(numero);
	
					Joueur joueur = (Joueur) actionPresentation.getObjetARetourner();
	
					if(joueur.isStatut() == true){
					    session.setAttribute("joueur", joueur);
						this.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
					}else{
						this.getServletContext().getRequestDispatcher("/connexion.jsp").forward(request, response);
					}
				}
				break;
			}
        } 
	}
	
	public void appelLecteur(int numero){
		Lecteur lecteur;
		if(numero == 0){
			lecteur = new Lecteur();
		}else{
			lecteur = new Lecteur(numero);
		}
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