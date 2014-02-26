package pl.bnsit.java.foundations.serialization;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XmlSerializationDepartmentDao implements DepartmentDao {
	
	private static XmlSerializationDepartmentDao INSTANCE;
	
	public static XmlSerializationDepartmentDao getInstance() {
		if ( INSTANCE == null ) {
			INSTANCE = new XmlSerializationDepartmentDao();
		}
		
		return INSTANCE;
	}
	

	private XStream stream = new XStream( new DomDriver() );
	
	private XmlSerializationDepartmentDao() {
	}
	
	@Override
	public Long saveDepartment(Department department) {
		long id = new Random(System.currentTimeMillis()).nextLong();
		department.setId(id);
		
		try {
			stream.toXML(department, new FileWriter( "department.xml" ));
		} catch (IOException e) {
			throw new RuntimeException("Bład zapisu do pliku XML", e); 
		}
		
		return id;
	}

	@Override
	public Department loadDepartment(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
