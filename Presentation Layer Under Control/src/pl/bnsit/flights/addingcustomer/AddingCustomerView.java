package pl.bnsit.flights.addingcustomer;

public interface AddingCustomerView {

	void showView();

	void hideView();

	String getFirstName();

	String getLastName();

	String getAddress();

	String getDayOfBirth();

	void showValidationFailedInfo();

	void updateComponent(String id, Object value);
}
