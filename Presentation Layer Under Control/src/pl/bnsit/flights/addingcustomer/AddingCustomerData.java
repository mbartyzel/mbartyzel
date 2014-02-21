package pl.bnsit.flights.addingcustomer;


public class AddingCustomerData {
	private String name;
	private String lastName;
	private String address;
	private String dayOfBirth;
	
	public AddingCustomerData(String name, String lastName, String address,
			String dayOfBirth) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.dayOfBirth = dayOfBirth;
	}
	
	public String getFirstName() {
		return name;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getDayOfBirth() {
		return dayOfBirth;
	}
}
