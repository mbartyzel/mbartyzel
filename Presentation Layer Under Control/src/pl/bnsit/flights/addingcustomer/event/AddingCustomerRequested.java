package pl.bnsit.flights.addingcustomer.event;

import java.util.Date;

public class AddingCustomerRequested {
	private String name;
	private String lastName;
	private String address;
	private String dayOfBirthAsString = null;
	private Date dayOfBirth;

	public AddingCustomerRequested(String name, String lastName, String address,
			String dayOfBirth) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.dayOfBirthAsString = dayOfBirth;
	}
	
	public AddingCustomerRequested() {
	}

	public void setDayOfBirth(Date dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}

	public String getName() {
		return name;
	}

	public String getDayOfBirthAsString() {
		return dayOfBirthAsString;
	}

	public void setDayOfBirthAsString(String dayOfBirthAsString) {
		this.dayOfBirthAsString = dayOfBirthAsString;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public Date getDayOfBirth() {
		return dayOfBirth;
	}
}
