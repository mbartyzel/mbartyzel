package pl.bnsit.util;

public interface TypeConverter {
	String toString( Object anObject );
	Object fromString( String str);
	Class type();
}
