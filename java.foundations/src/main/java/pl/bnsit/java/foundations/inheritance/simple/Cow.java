package pl.bnsit.java.foundations.inheritance.simple;

public class Cow extends Mammal {
	public void wydajDzwiek(){
		System.out.println( "Muuuuuuuuuuu!" );
	}

	@Override
	protected String getName() {
		return "Cow";
	}
}
