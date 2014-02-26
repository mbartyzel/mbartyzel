package pl.bnsit.java.foundations.exception;

public class Runner {

	public static void main(String[] args) {
		
		Stack<String> box = new Stack<String>(String.class, 3);
		box.push("a");
		box.push("b");
		box.push("c");
		
		box.push("c"); //przepełnienie stosu
		
		Stack<Integer> box2 = new Stack<Integer>(Integer.class, 2);
		box2.pop(); //próba pobrania z pustego stosu
	}
	
}
