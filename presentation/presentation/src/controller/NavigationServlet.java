package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
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
import comportement.presentation2metier.DemanderPremierLancerJeuP2MComportement;
import comportement.presentation2metier.DemanderRejoindrePartieP2MComportement;
import comportement.presentation2metier.ObtenirListePartiesP2MComportement;
import comportement.presentation2metier.RejoindrePartieP2MComportement;
import comportement.presentation2metier.SeConnecterP2MComportement;
import model.ActionPresentation;
import model.Jeu;
import model.Joueur;
import model.MessageErreur;
import model.Partie;
import model.Parties;

/**
 * Servlet implementation class NavigationServlet
 */
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ActionPresentation actionPresentation ;
	private String message;
	private MessageErreur messageErreur;
	private Jeu jeu;
	private int numero = 0;
	private ServletConfig config;
	public void init(ServletConfig config) throws ServletException{
		this.config = config;
		jeu = new Jeu();
		messageErreur = new MessageErreur();
		actionPresentation = new ActionPresentation();
		if(numero == 0){
			DemanderNumeroPresentationP2MComportement demanderNumeroPresentation = new DemanderNumeroPresentationP2MComportement();
			demanderNumeroPresentation.envoiMessage();
			actionPresentation.setObjetARetourner(null);
			appelLecteur(numero);
			numero = (Integer) actionPresentation.getObjetARetourner();
			actionPresentation.setObjetARetourner(null);
		}
	}
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {    
		HttpSession session = request.getSession();
		Joueur joueur = (Joueur) session.getAttribute("joueur");
		String message = "";
		String url = request.getParameter("nav");
		if(url == null){
			url = "";
		}
				
		if(joueur == null && !url.equals("formconnexion")){
			
			DemanderAuthentificationP2MComportement demanderAuthentification = new DemanderAuthentificationP2MComportement(numero);
			demanderAuthentification.envoiMessage();
			appelLecteur(numero);

			messageErreur = (MessageErreur) actionPresentation.getObjetARetourner();
			actionPresentation.setObjetARetourner(null);

			if(messageErreur.isStatut() == true){
				config.getServletContext().getRequestDispatcher("/connexion.jsp").forward(request, response);
			}else{
				config.getServletContext().getRequestDispatcher("/erreur.jsp").forward(request, response);
			}
		}else if(url.equals("creercompte") && joueur == null){
			response.sendRedirect("creercompte.jsp");
		}else {
		switch(url){
			case "":
				config.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
				break;
			case "rejoindrepartie" :
				
				DemanderRejoindrePartieP2MComportement demanderRejoindrePartie = new DemanderRejoindrePartieP2MComportement(numero);
				demanderRejoindrePartie.envoiMessage();
				
				appelLecteur(numero);

				messageErreur = (MessageErreur) actionPresentation.getObjetARetourner();
				actionPresentation.setObjetARetourner(null);

				if(messageErreur.isStatut() == true){

					ObtenirListePartiesP2MComportement obtenirListeParties = new ObtenirListePartiesP2MComportement(numero);
					obtenirListeParties.envoiMessage();
					
					appelLecteur(numero);
					Parties listeParties = (Parties) actionPresentation.getObjetARetourner();
					actionPresentation.setObjetARetourner(null);
					request.setAttribute("listeParties", listeParties);
					config.getServletContext().getRequestDispatcher("/rejoindrepartie.jsp").forward(request, response);
				}else{
					config.getServletContext().getRequestDispatcher("/erreur.jsp").forward(request, response);
				}				
				break;
			case "creerpartie" :
				DemanderCreerPartieP2MComportement demanderCreerPartie = new DemanderCreerPartieP2MComportement(numero);
				demanderCreerPartie.envoiMessage();
				appelLecteur(numero);

				messageErreur = (MessageErreur) actionPresentation.getObjetARetourner();
				actionPresentation.setObjetARetourner(null);
				if(messageErreur.isStatut() == true){
					config.getServletContext().getRequestDispatcher("/creerpartie.jsp").forward(request, response);
				}else{
					config.getServletContext().getRequestDispatcher("/erreur.jsp").forward(request, response);
				}
				break;
			case "jeu" :
				config.getServletContext().getRequestDispatcher("/jeu.jsp").forward(request, response);
				break;
			case "deconnexion" :
				request.getSession().invalidate();
				response.sendRedirect("navigation?nav=");
				break;
			case "modifierprofil" :
				config.getServletContext().getRequestDispatcher("/modifierprofil.jsp").forward(request, response);
				break;
			case "consulterscore" :
				config.getServletContext().getRequestDispatcher("/consulterscore.jsp").forward(request, response);
				break;
			case "accueil" :
				if(session.getAttribute("jeu")!= null){
					jeu = (Jeu) session.getAttribute("jeu");
					messageErreur = new MessageErreur();
					messageErreur.setMessage(jeu.getMessage());					
					jeu.setMessage(null);
				}
				session.setAttribute("jeu", jeu);
				request.setAttribute("messageErreur", messageErreur);
				config.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
				break;
			case "formrejoindrepartie" :
				String partieARejoindre = request.getParameter("partieARejoindre");
				Partie unePartieARejoindre = new Partie(partieARejoindre);
				RejoindrePartieP2MComportement rejoindrePartie = new RejoindrePartieP2MComportement(joueur, unePartieARejoindre, numero);
				rejoindrePartie.envoiMessage();
				
				appelLecteur(numero);

				jeu = (Jeu) actionPresentation.getObjetARetourner();
				actionPresentation.setObjetARetourner(null);
				if(jeu.isStatut() == true){
					session.setAttribute("jeu", jeu);
					config.getServletContext().getRequestDispatcher("/attentecommencerpartie.jsp").forward(request, response);
				}else{
					request.setAttribute("jeu", jeu);
					ObtenirListePartiesP2MComportement obtenirListeParties = new ObtenirListePartiesP2MComportement(numero);
					obtenirListeParties.envoiMessage();
					
					appelLecteur(numero);
					Parties listeParties = (Parties) actionPresentation.getObjetARetourner();
					actionPresentation.setObjetARetourner(null);
					request.setAttribute("listeParties", listeParties);
					config.getServletContext().getRequestDispatcher("/rejoindrepartie.jsp").forward(request, response);
				}
				break;
			case "formcreerpartie" :
				String nomPartie = request.getParameter("nom");
				String nbJoueurPartie = request.getParameter("nbjoueur");
				int nbJoueur = Integer.parseInt(nbJoueurPartie);
				CreerPartieP2MComportement creerPartie = new CreerPartieP2MComportement(nomPartie, nbJoueur, numero);
				creerPartie.envoiMessage();
	
				appelLecteur(numero);
	
				Partie partie = (Partie) actionPresentation.getObjetARetourner();
				actionPresentation.setObjetARetourner(null);

				if(partie.isStatut() == true){
					response.sendRedirect("navigation?nav=rejoindrepartie");
				}else{
					request.setAttribute("partie", partie);
					config.getServletContext().getRequestDispatcher("/creerpartie.jsp").forward(request, response);
				}
				break;
			case "formcreercompte" :
				String loginCreerCompte = request.getParameter("login");
			    String mdpCreerCompte = request.getParameter("pwd");
			    String nomCreerCompte = request.getParameter("nom");
			    String prenomCreerCompte = request.getParameter("prenom");
				if(loginCreerCompte.isEmpty() || mdpCreerCompte.isEmpty() || nomCreerCompte.isEmpty() || prenomCreerCompte.isEmpty()){
		        	request.setAttribute("message", "Les champs doivent être remplis");
		        }
		        config.getServletContext().getRequestDispatcher("/creercompte.jsp").forward(request, response);  
				break;
			case "formmodifierprofil" :
				String loginModifProfil = request.getParameter("login");
			    String mdpModifProfil = request.getParameter("pwd");
			    String nomModifProfil = request.getParameter("nom");
			    String prenomModifProfil = request.getParameter("prenom");
				if(loginModifProfil.isEmpty() || mdpModifProfil.isEmpty() || nomModifProfil.isEmpty() || prenomModifProfil.isEmpty()){
		        	request.setAttribute("message", "Les champs doivent être remplis");
		        }
		        config.getServletContext().getRequestDispatcher("/modifierprofil.jsp").forward(request, response);  
				break;
			case "formconnexion" :
				if(joueur != null){
					response.sendRedirect("navigation?nav=accueil");
				}else if(joueur == null && request.getParameter("login") == null){
					response.sendRedirect("navigation?nav=");
				}else{
					String loginConnexion = request.getParameter("login");
					String mdpConnexion = request.getParameter("pwd");
					SeConnecterP2MComportement authentification = new SeConnecterP2MComportement(loginConnexion, mdpConnexion, numero);
					authentification.envoiMessage();
	
					appelLecteur(numero);
	
					joueur = (Joueur) actionPresentation.getObjetARetourner();
					actionPresentation.setObjetARetourner(null);

					if(joueur.isStatut() == true){
					    session.setAttribute("joueur", joueur);
						config.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
					}else{
						request.setAttribute("joueur", joueur);
						config.getServletContext().getRequestDispatcher("/connexion.jsp").forward(request, response);
					}
				}
				break;
			case "redirectionjeu":
				
				appelLecteur(numero);

				jeu = (Jeu) actionPresentation.getObjetARetourner();
				actionPresentation.setObjetARetourner(null);
				session.setAttribute("jeu", jeu);
				if(jeu.getMessage() != null){
					message = jeu.getMessage();
				}
				response.setContentType("text");
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().write(message);
				break;
			case "formjeupremierlancer" :
				DemanderPremierLancerJeuP2MComportement demanderPremierLancerJeu = new DemanderPremierLancerJeuP2MComportement(numero, (Jeu) session.getAttribute("jeu"));
				demanderPremierLancerJeu.envoiMessage();
				
				//Essayer avec sendredirect
				config.getServletContext().getRequestDispatcher("/attentelancer.jsp").forward(request, response);
				break;
			case "formjeujoueur":
				
				break;
			case "redirectionlancer":
				
				appelLecteur(numero);
				
				jeu = (Jeu) actionPresentation.getObjetARetourner();
				System.out.println("actionPresentation : "+actionPresentation.getObjetARetourner().getClass());
				actionPresentation.setObjetARetourner(null);
				System.out.println("JEU présentation : "+numero+" "+jeu.getClass());
				session.setAttribute("jeu", jeu);
				if(jeu.getMessage() != null){
					message = jeu.getMessage();
				}
				response.setContentType("text");
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().write(message);
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