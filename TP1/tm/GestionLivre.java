package tm ;

import javax.persistence.*;
import javax.ejb.Stateless;

@Stateless
public class GestionLivre implements IGestionLivre {

	@PersistenceContext(unitName = "bookstorePU")
	private EntityManager entityManager ;

	public void ajouterLivre(String id, String name) {
		try {
			EntityLivre livre = new EntityLivre(id, name) ;
			entityManager.persist(livre) ;
		}
		catch(Exception e) {
			System.out.println(e.getMessage()) ;
		}
	}
}