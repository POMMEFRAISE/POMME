package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import comportement.Commande;

public class Filtre implements Filter{

	public void destroy() {
		this.destroy();
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		filterChain.doFilter(request, response);
		System.out.println("FILTER");
		Commande commande = null;
		while(commande.reçoiMessage().equals(null)){
			System.out.println("En traitement ...");
		}
		System.out.println("Traitement terminé ...");
			request.getRequestDispatcher("/"+commande.reçoiMessage()+".jsp").forward(request,response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		//ServletContext sc = filterConfig.getServletContext();
	}
}