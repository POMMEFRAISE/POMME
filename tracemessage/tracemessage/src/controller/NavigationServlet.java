package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.ActionTechnique;
import modele.Message;
import modele.Messages;

public class NavigationServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idMessage;
		String message = "";
		String queue;
        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        
        queue = reader.readLine();
        idMessage = reader.readLine();
        while(reader.ready()){
        	message = message + reader.readLine();
        }
        reader.close();

		String cheminCompletFichier = this.getServletContext().getRealPath("/WEB-INF/fichiers/messages.dat");
        Messages messages = new Messages();
        messages = ActionTechnique.lireFichier(cheminCompletFichier);
        
		if(request.getParameter("nav")==null){
			HttpSession session = request.getSession();
			session.setAttribute("messages", messages);
	        this.getServletContext().getRequestDispatcher("/WEB-INF/vue/index.jsp").forward(request, response); 
		}else{
		switch(request.getParameter("nav")){
			case "ecrireFichier" :
		        Message messageTrace = new Message(idMessage, message, queue);
		        messages.add(messageTrace);
				ActionTechnique.ecrireFichier(messages, cheminCompletFichier);
				break;
		}
		} 
	}
}