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

	public void supprimerLivre(String id) {
		try {
			EntityLivre livre = entityManager.find(EntityLivre.class, id) ;
			entityManager.remove(livre) ;
		}
		catch(Exception e) {
			System.out.println(e.getMessage()) ;
		}
	}

	public void emprunterLivre(String id) {
		try {
			EntityLivre livre = entityManager.find(EntityLivre.class, id) ;
			if(livre.getDispo() == 1) {
				System.out.println("Le livre "+livre.getTitre()+" est emprunté !!") ;
				livre.setDispo(0) ;
				entityManager.flush();
			}
			else {
				System.out.println("Le livre "+livre.getTitre()+" ne peut être emprunté !! :'(") ;
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage()) ;
		}
	}

	public void rendreLivre(String id) {
		try {
			EntityLivre livre = entityManager.find(EntityLivre.class, id) ;
			livre.setDispo(1) ;
			entityManager.flush();
		}
		catch(Exception e) {
			System.out.println(e.getMessage()) ;
		}
	}
}