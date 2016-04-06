package controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/NavigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		HttpSession session = request.getSession();
		if (request.getParameter("nav").equals("rejoindrepartie")) {
			this.getServletContext().getRequestDispatcher("/rejoindrepartie.jsp").forward(request, response);
		} else if (request.getParameter("nav").equals("creerpartie")) {
			this.getServletContext().getRequestDispatcher("/creerpartie.jsp").forward(request, response);
		}else if (request.getParameter("nav").equals("jeu")) {
			this.getServletContext().getRequestDispatcher("/jeu.jsp").forward(request, response);
		}else if (request.getParameter("nav").equals("deconnexion")) {
			session.invalidate();
			response.sendRedirect("connexion");
		}else if (request.getParameter("nav").equals("creercompte")) {
			response.sendRedirect("creercompte.jsp");
		}
	}

}
