package tm;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SecondServlet extends HttpServlet {
	
	/**
	 * Méthode permettant d'afficher un nom
	 * 
	 * @param request [description]
	 * @param response [description]
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig sc = getServletConfig() ;
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name") ;

		//Cookie de base
		Cookie cookie = new Cookie("name", name) ;

		if(!name.isEmpty()) {
			response.addCookie(cookie) ;
		}

		//Si le nom est null on met un nom par défault
		if(name.isEmpty()) {
			name = sc.getInitParameter("name") ;
			cookie.setMaxAge(0) ;
			response.addCookie(cookie) ;
		}
		
		out.println("<!DOCTYPE html>" +
					"<html>"+
					"<head>"+
					"<meta charset=\"UTF-8\">"+
					"<title>title</title>"+
  					"</head>"+
  					"<body>"+
  					"<a href=\"premier\">Cliquez-ici pour revenir au debut</a>"+
  					"<br><br>"+
  					"<a href=\"troisieme\">Cliquez-ici pour la page suivante</a>"+
  					"<form action=\"second\" method=\"post\">"+
					"<label for=\"name\">Nom : </label>"+
					"<input type=\"hiden\" id=\"id\" name=\"name\" value=\"" + name + "\">"+
					"<input type=\"submit\" value=\"Enregistrer\">"+
  					"</body>"+
					"</html>");
	}
}