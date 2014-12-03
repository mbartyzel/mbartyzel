package pl.bnsit.java.foundations.inheritance.simple;

public class Cat extends Mammal {
	public void wydajDzwiek(){
		System.out.println( "Miaaaaauuuuu!" );
	}

	@Override
	protected String getName() {
		return "Cat";
	}
}
