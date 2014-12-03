package pl.bnsit.java.foundations.interfaces.department;


public class Departament {

	public void zacznijDzien() {
		System.out.println( "Odbiłem kartę na początek dnia" );
	}
	
	public void zamknijDzien() {
		System.out.println( "Odbiłem kartę na koniec dnia" );

	}
	
	public String znajdzSzefa() {
		return "Szef wszystkich szefów";
	}
	
	public int obliczKoszty() {
		return 10000;
	}
	
	public void przeniesWStrukturze( String divisionName ) {
		System.out.println( "Przeniosłem ten departament do innej jednostki" );
	}
	
	public String dajNazwe() {
		return "Departament ds. Pewnych Problemów";
	}
	
	public String getDescription() {
		return "Generalnie nic tu nie robimy";
	}
	
}
