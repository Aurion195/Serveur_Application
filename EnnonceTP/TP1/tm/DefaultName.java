package tm;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DefaultName extends HttpServlet {
	
	/**
	 * Méthode permettant de changer le nom par défault
	 * 
	 * @param request [description]
	 * @param response [description]
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext scContect = getServletContext();
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name") ;

		//Si le nom est null on met un nom par défault
		if(name != null) {
			scContect.setAttribute("name", name) ;
		}
		
		out.println("Voici le nouveau nom par défault ->  " + name);
	}
}