package tm ;

import javax.ejb.Remote;

@Remote
public interface IBeanStateless { 
	public String display(String text) ;
}