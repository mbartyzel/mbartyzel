package pl.bnsit.java.foundations.encapsulation.advanced;

public class Runner {
	
	public static void main(String[] args) {

		Czlowiek piotr = new Czlowiek("Piotr", "Kowalski");
		Czlowiek krysia = new Czlowiek("Piotr", "Kowalski");
		
		System.out.println( piotr );
		
		System.out.println( piotr.equals( krysia ) );
		
		System.out.println( "Piotra " + piotr.hashCode());
		System.out.println( "Krysia " + krysia.hashCode());
		
	}
}
