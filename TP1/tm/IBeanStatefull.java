package tm ;

import javax.ejb.Remote;

@Remote
public interface IBeanStatefull { 
	public String display(String text) ;
	public String re_display() ;
}