package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import model.ActionPresentation;

public class Filtre implements Filter{

	public void destroy() {
		this.destroy();
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("FILTER");
		filterChain.doFilter(request, response);
		System.out.println("FILTER 2");
		while(ActionPresentation.getEnTraitement().equals("oui")){
			System.out.println("En traitement ...");
		}
		System.out.println("Traitement terminé ...");
		request.getRequestDispatcher("/"+ActionPresentation.getPageRedirection()+".jsp").forward(request,response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		//ServletContext sc = filterConfig.getServletContext();
	}
}