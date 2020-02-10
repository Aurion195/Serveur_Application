package tm;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Connexion extends HttpServlet {
	
	/**
	 * Méthode permettant de changer le nom par défault
	 * 
	 * @param request [description]
	 * @param response [description]
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		//Permet d'invalider une session
		HttpSession sessionInvalide = request.getSession();
		sessionInvalide.invalidate();

		
		out.println("<!DOCTYPE html>"+
					"<html>"+
					"<head>"+ 
					"<meta charset=\"UTF-8\">"+
					"<title>title</title>"+
  					"</head>"+
  					"<body>"+
  					"<h1>Bienvenue sur le site du gros garcia !!</h1>"+
					"<form action=\""+response.encodeURL("details")+"\" method=\"post\">"+
					"<label for=\"name\">Nom :</label>"+
					"<input type=\"hiden\" id=\"id\" type=\"text\" name=\"name\">"+
					"<input type=\"submit\" value=\"Connexion\">"+
					"</form>"+
  					"</body>"+
					"</html>");
	}
}