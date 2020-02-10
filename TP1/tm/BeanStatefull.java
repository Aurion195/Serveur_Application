package tm ;

import javax.ejb.Stateful;

@Stateful
public class BeanStatefull implements IBeanStatefull {

	private String name = "Thomas" ;

	public String display(String text) {
		this.name = text ;
		return "Display ------ Bonjour -> " + this.name ;
	}

	public String re_display() {
		return "ReDisplay ------ Bonjour -> " + this.name ;
	}
}