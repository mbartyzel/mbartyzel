package pl.bnsit.java.foundations.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

import pl.bnsit.java.foundations.NotImplementedYetException;

public class BinarySerializationDepartmentDao implements DepartmentDao {

	private Random randomizer = new Random(System.currentTimeMillis()); 
	
	/* (non-Javadoc)
	 * @see pl.bnsit.java.foundations.serialization.DepartmentDao#saveDepartment(pl.bnsit.java.foundations.serialization.Department)
	 */
	@Override
	public Long saveDepartment(Department department) {
		long storedId = randomizer.nextLong();
		department.setId(storedId);
		
		try {
			new ObjectOutputStream( new FileOutputStream(storedId + ".store") ).writeObject(department);
		} catch (IOException e) {
			throw new RuntimeException("Błąd odczytu", e);
		} 
		
		return storedId;
	} 
	
	/* (non-Javadoc)
	 * @see pl.bnsit.java.foundations.serialization.DepartmentDao#loadDepartment(java.lang.Long)
	 */
	@Override
	public Department loadDepartment(Long id) {
		Object object;
		try {
			object = new ObjectInputStream( new FileInputStream( id + ".store" )).readObject();
		} catch (Exception e) {
			throw new RuntimeException("Błąd zapisu", e);
		}
		Department department = upCast(object);
		
		return department;
	}

	private Department upCast(Object object) {
		
		//dla kazdego pola z dep sprawdź czy istnieje odpoweidnik w object i przekopij wartość
		//dla nieustawionych pól nadaj wartość domyślną
		
		return (Department) object;
	}
}
