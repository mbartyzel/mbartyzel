package pl.bnsit.flights.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class SerializationDao implements Dao {

	private static final String DB_FILE_NAME = "_flights.db";
	
	private SerializedBean serializedBean; 
	
	@Override
	public void saveCustomer(Customer customer) {
		loadBean();
		serializedBean.put( customer );
		saveBean();
	}
	
	private void loadBean() {
		ObjectInputStream stream = null;
		
		try {
			stream = new ObjectInputStream( new FileInputStream( DB_FILE_NAME ) );
			serializedBean = (SerializedBean) stream.readObject();
			
		} catch (FileNotFoundException e) {
			System.out.println( "INFO: Brak pliku z baz¹ danych. " +
					"Prawdopodobnie jest to pierwsze uruchomienie aplikacji. Zak³adam now¹ bazê. " );
			serializedBean = new SerializedBean();
			saveBean();
		} catch (IOException e) {
			throw new ApplicationDaoException( "Cannot read database file", e );
		} catch (ClassNotFoundException e) {
			throw new ApplicationDaoException( "Cannot read data from database file", e );
		}
	}

	private void saveBean() {

		ObjectOutputStream stream = null;
		try {
			
			stream = new ObjectOutputStream(
					new FileOutputStream( DB_FILE_NAME ) );

			stream.writeObject( serializedBean );
			
		} catch (FileNotFoundException e) {
			throw new ApplicationDaoException( "Cannot find database file", e );
		} catch (IOException e) {
			throw new ApplicationDaoException( "Cannot write database file", e );
		} 
	}
}
