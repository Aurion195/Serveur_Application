package tm ;

import javax.ejb.Stateless;

@Stateless
public class BeanStateless implements IBeanStateless {

	public String display(String text) {
		return "Bonjour -> " + text ;
	}
}