package pl.bnsit.account.details;

public interface DetailsViewObserver {
	
	void propertyChanged( String property, Object value );
	
	void viewIsReady();
}
