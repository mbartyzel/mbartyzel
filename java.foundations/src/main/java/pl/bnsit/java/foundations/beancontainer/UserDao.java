package pl.bnsit.java.foundations.beancontainer;

import pl.bnsit.java.foundations.beancontainer.containerimpl.Init;

public class UserDao {

	public void saveUser( String userName ) {
		
	}
	
	@Init
	public void init() {
		System.out.println( "Establishing database connection..." );
	}
}
