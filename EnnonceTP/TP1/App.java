import java.io.*;
import java.net.*;

public class App {

	/**
	 * Permet de se connecter et d'afficher ce qu'il y a marqué dans la page web
	 * 
	 * @param args = argument ;
	 */
	public static void main(String[] args) {
		try {
			//On se connecte à la page
			URL url = new URL("http://e-mc136-121:8080/TP18420804456423387317/HelloWorld");
			URLConnection myUrl = url.openConnection() ;
			myUrl.connect() ;

			//On va lire les valeurs dans la page web
			BufferedReader br = new BufferedReader(new InputStreamReader(myUrl.getInputStream()));   
            String i;   

            while((i = br.readLine()) != null)    
            {   
                System.out.println(i);   
            }   
        }     
        catch (Exception e)    
        {   
            System.out.println(e);   
        }
	}
}