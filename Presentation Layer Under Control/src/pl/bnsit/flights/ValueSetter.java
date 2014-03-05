package pl.bnsit.flights;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JTextField;

public abstract class ValueSetter {

	private static Map<Class<?>, ValueSetter> SETTERS;
	
	static {
		SETTERS = new HashMap<Class<?>, ValueSetter>();
		SETTERS.put(JTextField.class, new JTextFieldSetter());
	}
	
	public static ValueSetter get( Class<?> type ) {
		if( SETTERS.containsKey(type) ) {
			return SETTERS.get(type);
		}
		
		throw new IllegalArgumentException( "Missing ValueSetter for " + type );
	}
	
	public abstract void set( Object target, Object value );

	private static class JTextFieldSetter extends ValueSetter {
		@Override
		public void set(Object target, Object value) {
			((JTextField)target).setText( (String) value );
		}
	}
}
