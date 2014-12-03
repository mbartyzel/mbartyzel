package pl.bnsit.java.foundations.encapsulation.advanced;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Czlowiek {

	private String name;

	private String surname;
	
	private Phone telefon;
	
	public Czlowiek(String imie, String surname) {
		this.name = imie;
		this.surname = surname;
		this.telefon = new Phone();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, false);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, false);
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
