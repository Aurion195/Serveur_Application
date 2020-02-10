package tm ;

import javax.persistence.*;
import javax.ejb.Remote;

@Remote
public interface IGestionLivre { 
	public void ajouterLivre(String id, String name);
	public void supprimerLivre(String id);
	public void emprunterLivre(String id);
	public void rendreLivre(String id);
}