import tm.*;
import javax.naming.*;

public class ClientJNDI {

	public static void functionExo1() {
		System.out.println("Voici le 1er exercice avec Stateless");

		try {
			InitialContext ctx = new InitialContext();
			IBeanStateless beanTest = (IBeanStateless)ctx.lookup("tm.IBeanStateless");
			System.out.println(beanTest.display("Thomas")) ;
		}
		catch(Exception e) {
			System.out.println(e.getMessage()) ;
		}
	}

	public static void functionExo2() {
		System.out.println("\n \n \nVoici le 1er exercice avec Stateful");

		try {
			InitialContext ctx = new InitialContext();
			IBeanStatefull beanTest = (IBeanStatefull)ctx.lookup("tm.IBeanStatefull");
			System.out.println(beanTest.display("Thomas")) ;
			System.out.println(beanTest.re_display()) ;
			System.out.println(beanTest.display("Jérémy")) ;
			System.out.println(beanTest.re_display()) ;
		}
		catch(Exception e) {
			System.out.println(e.getMessage()) ;
		}
	}


	public static void main(String[] args) {
		try {
			InitialContext ctx = new InitialContext();
			IGestionLivre beanTest = (IGestionLivre)ctx.lookup("tm.IGestionLivre");
			//beanTest.ajouterLivre("648", "Le Java") ;
			//beanTest.ajouterLivre("649", "Le c++") ;
			//System.out.println("Le livre a été ajouté");
			//beanTest.supprimerLivre("648") ;
			//System.out.println("Le livre a été supprimé");
			beanTest.emprunterLivre("649");
			beanTest.rendreLivre("649");
		}
		catch(Exception e) {
			System.out.println(e.getMessage()) ;
		}
	}
}