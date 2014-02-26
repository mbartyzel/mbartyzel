package pl.bnsit.java.foundations.exception;

import java.lang.reflect.Array;

public class Stack<T> {

	private T[] stack;
	
	private int index;
	
	public Stack(Class<T> clazz, int capactity) {
		stack = (T[]) Array.newInstance(clazz, capactity);
		index = -1;
	}
	
	public void push(T element) {
		stack[++index] = element;
	}
	
	public T pop() {
		T element = stack[index];
		stack[index--] = null;
		
		return element;
	}
}
