package pl.bnsit.java.foundations.serialization;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Department implements Serializable {

	private Long id;
	
	private String name;
	
	private String description;
	
//	private String address;
	
	private Map<Long, Employee> employees = new HashMap<>();

	public Department(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	public void addEmployee(Employee employee) {
		employees.put(employee.getId(), employee);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Map<Long, Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Map<Long, Employee> employees) {
		this.employees = employees;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
