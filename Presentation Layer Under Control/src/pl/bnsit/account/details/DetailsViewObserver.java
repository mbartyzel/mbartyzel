package pl.bnsit.account.details;

public interface DetailsViewObserver {
	
	void updateViewModel( String property, Object value );
	
	void viewIsReady();
}
