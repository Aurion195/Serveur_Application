package tm;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class PremierServlet extends HttpServlet {
	
	/**
	 * Méthode permettant de changer le nom par défault
	 * 
	 * @param request [description]
	 * @param response [description]
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String name = PremierServlet.getCookieValue(request.getCookies(), "name", "") ;

		out.println("<!DOCTYPE html>"+
					"<html>"+
					"<head>"+ 
					"<meta charset=\"UTF-8\">"+
					"<title>title</title>"+
  					"</head>"+
  					"<body>"+
  					"<h1>Voici le nom du cookies : "+ name + "</h1>"+
  					"<h1>Saluer un joueur</h1>"+
					"<form action=\"second\" method=\"post\">"+
					"<label for=\"name\">Nom :</label>"+
					"<input type=\"hiden\" id=\"id\" type=\"text\" name=\"name\">"+
					"<input type=\"submit\" value=\"Enregistrer\">"+
					"</form>"+
  					"</body>"+
					"</html>");
	}

	public static String getCookieValue(Cookie [] cookies, String cookieName, String defaultValue) {
		if(cookies == null) return defaultValue ;

		for(int i = 0 ; i < cookies.length; i++) {
			Cookie cookie = cookies[i];
			if(cookieName.equals(cookie.getName())) {
				return(cookie.getValue());
			}
		}

		return(defaultValue);
	}
}