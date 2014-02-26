package pl.bnsit.java.foundations.serialization;

import java.io.Serializable;


public class Employee implements Serializable {

	private Long id;

	private String name;
	
	private int age;
	
	public Employee(Long id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public Long getId() {
		return id;
	}
}
