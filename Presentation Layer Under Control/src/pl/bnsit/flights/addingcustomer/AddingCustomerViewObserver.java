package pl.bnsit.flights.addingcustomer;

public interface AddingCustomerViewObserver {

	void cancelButtonClicked();

	void addButtonClicked();
	
	void updateViewModel( String property, Object value );

}
