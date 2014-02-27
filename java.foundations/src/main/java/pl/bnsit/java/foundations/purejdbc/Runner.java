package pl.bnsit.java.foundations.purejdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Runner {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("org.hsqldb.jdbcDriver");
		Connection connection = DriverManager.getConnection(
				"jdbc:hsqldb:file:target/classes/pl/bnsit/java/foundations/purejdbc/db", "sa", "");
		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery( "select * from loty;" );
		
		//Wypisz wynik zapytania na konsolę
	}
	
}
