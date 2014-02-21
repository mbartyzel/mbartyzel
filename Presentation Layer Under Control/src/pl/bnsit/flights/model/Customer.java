package pl.bnsit.flights.model;

import java.io.Serializable;
import java.util.Date;



public class Customer implements Serializable, Identifiable {

	private Long id;
	
	private String name;
	private String lastName;
	private String address;
	private Date dayOfBirth;

	public Customer(String name, String lastName, String address,
			Date dayOfBirth) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.dayOfBirth = dayOfBirth;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getDayOfBirth() {
		return dayOfBirth;
	}
	public void setDayOfBirth(Date dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
