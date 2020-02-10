package tm;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloWorld extends HttpServlet {
	
	/**
	 * Méthode permettant d'afficher un helloword
	 * 
	 * @param request [description]
	 * @param response [description]
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig sc = getServletConfig() ;
		PrintWriter out = response.getWriter();
		out.println("Hello world ! Version GET   ----> " + request.getParameter("param1") + "\n \nVoici le nom ----> " + sc.getServletName());
	}

	/**
	 * Méthode permettant d'afficher un helloword
	 * 
	 * @param request [description]
	 * @param response [description]
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig sc = getServletConfig() ;
		ServletContext scContexte = getServletContext();
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name") ;

		//Si le nom est null on met un nom par défault
		if(name.isEmpty()) {
			name = sc.getInitParameter("name") ;
		}
		
		out.println("Hello world ! version POST   ----> " + name + "\n \nVoici le nom ----> " + sc.getServletName() + 
					"\n \nVoici le nom par défault du contexte ----> " + scContexte.getAttribute("name"));
	}
}