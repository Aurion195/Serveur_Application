package tm;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Affichage extends HttpServlet {
	
	/**
	 * Méthode permettant de changer le nom par défault
	 * 
	 * @param request [description]
	 * @param response [description]
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session == null) {
			response.sendRedirect("connexion");
		}
		else {
			PrintWriter out = response.getWriter();

			String date = request.getParameter("date");
			String codePostale = request.getParameter("cp");

			session.setAttribute("date", date) ;
			session.setAttribute("CP", codePostale) ;

			out.println("<!DOCTYPE html>"+
					"<html>"+
					"<head>"+ 
					"<meta charset=\"UTF-8\">"+
					"<title>title</title>"+
  					"</head>"+
  					"<body>"+
  					"<h1>Bienvenue : "+ session.getAttribute("nom") + "</h1>"+
  					"<h3>Voici les informations que vous avez enregistrer</h3>"+
					"<p>Date de naissance -> " + session.getAttribute("date") + "</p>"+
					"<p>Code postale -> " + session.getAttribute("CP") + "</p>"+
					"</form>"+
					"<a href=\""+response.encodeURL("page1")+"\">Aller sur la page 1</a>"+
					"<br>"+
					"<a href=\""+response.encodeURL("page2")+"\">Aller sur la page 2</a>"+
					"<br>"+
					"<a href=\""+response.encodeURL("details")+"\">Modifier vos information</a>"+
					"<br>"+
					"<a href=\""+response.encodeURL("connexion")+"\">Se deconnecter</a>"+
  					"</body>"+
					"</html>");
		}
	}

	/**
	 * Méthode permettant de changer le nom par défault
	 * 
	 * @param request [description]
	 * @param response [description]
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession(false);
		if(session == null) {
			response.sendRedirect("connexion");
		}
		else {
			out.println("<!DOCTYPE html>"+
					"<html>"+
					"<head>"+ 
					"<meta charset=\"UTF-8\">"+
					"<title>title</title>"+
  					"</head>"+
  					"<body>"+
  					"<h1>Bienvenue : "+ session.getAttribute("nom") + "</h1>"+
  					"<h3>Voici les informations que vous avez enregistrer</h3>"+
					"<p>Date de naissance -> " + session.getAttribute("date") + "</p>"+
					"<p>Code postale -> " + session.getAttribute("CP") + "</p>"+
					"</form>"+
					"<a href=\""+response.encodeURL("page1")+"\">Aller sur la page 1</a>"+
					"<br>"+
					"<a href=\""+response.encodeURL("page2")+"\">Aller sur la page 2</a>"+
					"<br>"+
					"<a href=\""+response.encodeURL("details")+"\">Modifier vos information</a>"+
					"<br>"+
					"<a href=\""+response.encodeURL("connexion")+"\">Se deconnecter</a>"+
  					"</body>"+
					"</html>");
		}
	}	
}