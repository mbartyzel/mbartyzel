package pl.bnsit.java.foundations.autosetters;

import java.lang.reflect.Method;

public class Runner {

	public static void main(String[] args) throws InstantiationException, Exception {
		
		Util.printSetters( Person.class );
		
	}
}
