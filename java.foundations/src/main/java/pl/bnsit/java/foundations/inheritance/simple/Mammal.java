package pl.bnsit.java.foundations.inheritance.simple;

public abstract class Mammal implements WydajaceDzwiek {

	public final void budzSie() {
		System.out.println(getName()+" is waking up...");
	}
	
	protected abstract String getName();
	
	public void stworzPotomstwo() {
		//Tu będzie implementacja wspólna dla wszystkich
	}
}
