package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Joueur;

/**
 * Servlet implementation class post
 */
@WebServlet("/post")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();

        /* S'il n'y a pas de session, on redirige vers la page de connexion, 
         * sinon vers l'accueil
         */
        if (session.getAttribute("utilisateur") == null) {
            response.sendRedirect("connexion");
        }else {
            this.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
        }
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		doGet(request, response);

	}
	
}