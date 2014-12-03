package pl.bnsit.java.foundations.encapsulation.advanced;

public class Czlowiek {

	private String name;

	private Phone telefon;
	
	public Czlowiek(String imie) {
		this.name = imie;
		this.telefon = new Phone();
	}

	public void zadzwon(String numberTelefonu) {
		
		int cyferka = 0;
		for(int i = 0; i < numberTelefonu.length(); ++i) {
			cyferka = Integer.parseInt( Character.toString( numberTelefonu.charAt(i) ) );
			
			switch ( cyferka ) {
			case 0: telefon.pressZero(); break;
			case 1: telefon.pressOne(); break;
			default: //zgłoś błąd
			}
				
		}
		
	}
}
