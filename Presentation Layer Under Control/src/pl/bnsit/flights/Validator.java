package pl.bnsit.flights;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import pl.bnsit.flights.addingcustomer.AddingCustomerData;


public class Validator {

	public boolean isValid(AddingCustomerData customerData) {
		
		if ( undefined(customerData.getFirstName()) ) {
			return false;
		}
		
		if ( undefined(customerData.getLastName()) ) {
			return false;
		}
		
		if ( undefined( customerData.getAddress() ) ) {
			return false;
		}
		
		SimpleDateFormat dateFormat = new SimpleDateFormat( "dd.MM.yyyy" );
		try {
			dateFormat.parse( customerData.getDayOfBirth() );
		} catch (ParseException ex) {
			return false;
		}		
		
		return true;
	}
	
	public boolean undefined( String aStr ) {
		return aStr == null || aStr.isEmpty();
	}

}
