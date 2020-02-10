package tm;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Page1 extends HttpServlet {
	
	/**
	 * Méthode permettant de changer le nom par défault
	 * 
	 * @param request [description]
	 * @param response [description]
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session == null) {
			response.sendRedirect("connexion");
		}
		else {
			PrintWriter out = response.getWriter();

			out.println("<!DOCTYPE html>"+
					"<html>"+
					"<head>"+ 
					"<meta charset=\"UTF-8\">"+
					"<title>title</title>"+
  					"</head>"+
  					"<body>"+
  					"<h1>Bienvenue : "+ session.getAttribute("nom") + "</h1>"+
  					"<h3>Vous êtes sur la page 1</h3>"+
  					"<br>"+
					"<a href=\""+response.encodeURL("page2")+"\">Aller sur la page 2</a>"+
					"<br>"+
					"<a href=\""+response.encodeURL("affichage")+"\">Revenir aux information</a>"+
					"<br>"+
					"<a href=\""+response.encodeURL("connexion")+"\">Se deconnecter</a>"+
					"<br>"+
  					"</body>"+
					"</html>");
		}
	}
}