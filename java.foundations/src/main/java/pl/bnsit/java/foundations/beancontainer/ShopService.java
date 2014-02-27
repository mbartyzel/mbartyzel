package pl.bnsit.java.foundations.beancontainer;

import pl.bnsit.java.foundations.beancontainer.containerimpl.Init;

public class ShopService {

	@Init
	public void businessMethod() {
		System.out.println( "Metoda inicjalizująca" );
	}
}
