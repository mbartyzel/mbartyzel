package pl.bnsit.flights;

import java.util.Date;

import pl.bnsit.flights.model.Customer;
import pl.bnsit.flights.model.Dao;

public class FlightService {

	private Dao dao;
	
	public FlightService(Dao dao) {
		super();
		this.dao = dao;
	}

	public void saveCustomer( String name, String lastName, String address, Date dayOfBirth ) {
		dao.saveCustomer( new Customer( name, lastName, address, dayOfBirth) );
	}
}
