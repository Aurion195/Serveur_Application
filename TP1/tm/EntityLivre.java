package tm;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "livre")
public class EntityLivre implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "isbn", nullable = false)
	private String id ;

	@Column(name = "titre")
	private String titre ;

	@Column(name = "dispo")
	private Integer dispo ;

	public EntityLivre() {

	}

	public EntityLivre(String id, String titre) {
		this.id = id ;
		this.titre = titre ;
		this.dispo = 1 ;
	}

	public String getId() {
		return this.id ;
	}

	public String getTitre() {
		return this.titre ;
	}

	public Integer getDispo() {
		return this.dispo ;
	}

	public void setId(String id) {
		this.id = id ;
	}

	public void setTitre(String titre) {
		this.titre = titre ;
	}

	public void setDispo(Integer dispo) {
		this.dispo = dispo ;
	}
}