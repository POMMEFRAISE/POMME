package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modele.Message;
import modele.Messages;

public class AccueilServlet extends HttpServlet
{
    private static final long serialVersionUID = 3239007136416961422L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

    	Messages messages = (Messages) session.getAttribute("messages");

        if(messages == null){
        	System.out.println("Bonjour");
        	messages = new Messages();
        }
       
        if(!messages.equals(null)){
            String message = request.getParameter("message");
            String idMessage = request.getParameter("idMessage");
            System.out.println("Trace message : message : "+message);
            
            Message unMessage = new Message(idMessage, message);
            messages.add(unMessage);
            session.setAttribute("messages", messages);
            request.setAttribute("messages", messages);
        }

		/* On redirige vers le formulaire d'affichage de la liste des messages */
        this.getServletContext().getRequestDispatcher("/WEB-INF/vue/jsp/index.jsp").forward(request, response);

	}
}