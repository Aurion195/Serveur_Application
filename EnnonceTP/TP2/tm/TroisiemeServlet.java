package tm;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class TroisiemeServlet extends HttpServlet {
	
	/**
	 * Méthode permettant d'afficher un nom
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
  					"<a href=\"premier\">Cliquez-ici pour revenir au début</a>"+
  					"<h1>Saluer un joueur -> "+name+"</h1>"+
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