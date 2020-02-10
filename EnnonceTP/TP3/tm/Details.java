package tm;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Details extends HttpServlet {
	
	/**
	 * Méthode permettant de changer le nom par défault
	 * 
	 * @param request [description]
	 * @param response [description]
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession(true);
			session.setAttribute("nom", request.getParameter("name")) ;
			PrintWriter out = response.getWriter();
			String name = request.getParameter("name") ;

			session.setAttribute("nom", name) ;

			out.println("<!DOCTYPE html>"+
					"<html>"+
					"<head>"+ 
					"<meta charset=\"UTF-8\">"+
					"<title>title</title>"+
  					"</head>"+
  					"<body>"+
  					"<h1>Bienvenue : "+ name + "</h1>"+
  					"<h3>Veuillez rentrer de nouvelles information</h3>"+
					"<form action=\""+response.encodeURL("affichage")+"\" method=\"post\">"+
					"<label for=\"date\">Date de naissance :</label>"+
					"<input id=\"id\" type=\"text\" name=\"date\">"+
					"<label for=\"cp\">Code postale :</label>"+
					"<input id=\"id\" type=\"text\" name=\"cp\">"+
					"<input type=\"submit\" value=\"Enregistrer\">"+
					"</form>"+
  					"</body>"+
					"</html>");
	}

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
  					"<h3>Veuillez rentrer de nouvelles information</h3>"+
					"<form action=\""+response.encodeURL("affichage")+"\" method=\"post\">"+
					"<label for=\"date\">Date de naissance :</label>"+
					"<input id=\"id\" type=\"text\" name=\"date\" value=\"" + session.getAttribute("date") + "\">"+
					"<label for=\"cp\">Code postale :</label>"+
					"<input id=\"id\" type=\"text\" name=\"cp\" value=\"" + session.getAttribute("CP") + "\">"+
					"<input type=\"submit\" value=\"Enregistrer\">"+
					"</form>"+
  					"</body>"+
					"</html>");
		}
	}

}