package pl.bnsit.java.foundations.inheritance.simple;

public class Dog extends Mammal {

	public void wydajDzwiek(){
		System.out.println( "Wolf, wolf!" );
	}

	@Override
	protected String getName() {
		return "Dog";
	}
}
